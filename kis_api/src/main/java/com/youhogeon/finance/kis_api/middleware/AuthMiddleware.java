package com.youhogeon.finance.kis_api.middleware;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

import com.youhogeon.finance.kis_api.KisClient;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppKeyRequired;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppSecretRequired;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppTokenRequired;
import com.youhogeon.finance.kis_api.api.annotation.auth.ApprovalKeyRequired;
import com.youhogeon.finance.kis_api.api.rest.auth.GetSocketApprovalKeyApi;
import com.youhogeon.finance.kis_api.api.rest.auth.GetSocketApprovalKeyResult;
import com.youhogeon.finance.kis_api.api.rest.auth.GetTokenApi;
import com.youhogeon.finance.kis_api.api.rest.auth.GetTokenResult;
import com.youhogeon.finance.kis_api.client.NetworkClient;
import com.youhogeon.finance.kis_api.client.NetworkRequest;
import com.youhogeon.finance.kis_api.config.Configuration;
import com.youhogeon.finance.kis_api.config.Credentials;
import com.youhogeon.finance.kis_api.context.ApiContext;
import com.youhogeon.finance.kis_api.context.ApiData;
import com.youhogeon.finance.kis_api.util.AnnotationUtil;
import com.youhogeon.finance.kis_api.util.CredentialsUtil;
import com.youhogeon.finance.kis_api.util.DateUtil;
import com.youhogeon.finance.kis_api.util.Pair;

public class AuthMiddleware implements Middleware {

    private final ConcurrentMap<Credentials, Pair<String, LocalDateTime>> appTokens = new ConcurrentHashMap<>();
    private final ConcurrentMap<Credentials, ReentrantLock> locks = new ConcurrentHashMap<>();

    private final ConcurrentMap<Credentials, Pair<NetworkClient, String>> approvalKeys = new ConcurrentHashMap<>();

    @Override
    public void before(KisClient client, ApiContext context) {
        NetworkRequest request = context.getRequest();

        ApiData apiData = context.getApiData();
        Credentials credentials = client.getConfig().getCredentials();

        boolean maskCredentials = client.getConfig().isMaskCredentials();

        Annotation[] annotations = apiData.getAnnotations();
        List<AppKeyRequired> appKeyAnnotations = AnnotationUtil.getAnnotations(annotations, AppKeyRequired.class);
        List<AppSecretRequired> appSecretAnnotations = AnnotationUtil.getAnnotations(annotations, AppSecretRequired.class);
        List<AppTokenRequired> appTokenAnnotations = AnnotationUtil.getAnnotations(annotations, AppTokenRequired.class);
        List<ApprovalKeyRequired> approvalKeyAnnotations = AnnotationUtil.getAnnotations(annotations, ApprovalKeyRequired.class);

        Map<String, Object> body = request.getBody();
        Map<String, Object> headers = request.getHeaders();

        Set<String> bodyKeys = new HashSet<>();
        Set<String> headersKeys = new HashSet<>();

        for (AppKeyRequired anno : appKeyAnnotations) {
            if (anno.location() == AppKeyRequired.Location.BODY) {
                bodyKeys.add(anno.key());
                body.put(anno.key(), credentials.getAppKey());
            } else if (anno.location() == AppKeyRequired.Location.HEADER) {
                headersKeys.add(anno.key());
                headers.put(anno.key(), credentials.getAppKey());
            }
        }

        for (AppSecretRequired anno : appSecretAnnotations) {
            if (anno.location() == AppSecretRequired.Location.BODY) {
                bodyKeys.add(anno.key());
                body.put(anno.key(), credentials.getAppSecret());
            } else if (anno.location() == AppSecretRequired.Location.HEADER) {
                headersKeys.add(anno.key());
                headers.put(anno.key(), credentials.getAppSecret());
            }
        }

        for (AppTokenRequired anno : appTokenAnnotations) {
            String appToken = anno.prefix() + getAppToken(client, context);

            if (anno.location() == AppTokenRequired.Location.BODY) {
                bodyKeys.add(anno.key());
                body.put(anno.key(), appToken);
            } else if (anno.location() == AppTokenRequired.Location.HEADER) {
                headersKeys.add(anno.key());
                headers.put(anno.key(), appToken);
            }
        }

        for (ApprovalKeyRequired anno : approvalKeyAnnotations) {
            String approvalKey = getApprovalKey(client, context);

            if (anno.location() == ApprovalKeyRequired.Location.BODY) {
                bodyKeys.add(anno.key());
                body.put(anno.key(), approvalKey);
            } else if (anno.location() == ApprovalKeyRequired.Location.HEADER) {
                headersKeys.add(anno.key());
                headers.put(anno.key(), approvalKey);
            }
        }

        if (maskCredentials) {
            request.setBody(CredentialsUtil.maskMap(body, bodyKeys.toArray(new String[0])));
            request.setHeaders(CredentialsUtil.maskMap(headers, bodyKeys.toArray(new String[0])));
        }
    }

    @Override
    public void after(KisClient client, ApiContext context) {

    }

    private String getApprovalKey(KisClient client, ApiContext context) {
        Configuration config = client.getConfig();
        Credentials credentials = config.getCredentials();

        if (credentials.getApprovalKey() != null) {
            return credentials.getApprovalKey();
        }

        NetworkClient currentClient = context.getNetworkClient();

        Pair<NetworkClient, String> pair = approvalKeys.compute(credentials, (creds, existingPair) -> {
            if (existingPair != null && existingPair.getFirst().equals(currentClient)) {
                return existingPair;
            }

            ApiContext authContext = new ApiContext(credentials);
            GetSocketApprovalKeyApi req = new GetSocketApprovalKeyApi();
            GetSocketApprovalKeyResult resp = client.execute(req, authContext);

            return Pair.of(currentClient, resp.getApprovalKey());
        });

        return pair.getSecond();
    }

    private String getAppTokenFromCache(Credentials credentials) {
        Pair<String, LocalDateTime> tokenInfo = appTokens.get(credentials);

        if (tokenInfo == null) {
            return null;
        }

        LocalDateTime accessTokenExpired = tokenInfo.getSecond();

        if (accessTokenExpired.isAfter(LocalDateTime.now().minusMinutes(1))) {
            return tokenInfo.getFirst();
        }

        return null;
    }

    private String getAppToken(KisClient client, ApiContext context) {
        Configuration config = client.getConfig();
        Credentials credentials = config.getCredentials();

        if (credentials.getAppToken() != null) {
            return credentials.getAppToken();
        }

        String cachedToken = getAppTokenFromCache(credentials);
        if (cachedToken != null) {
            return cachedToken;
        }

        ReentrantLock lock = locks.computeIfAbsent(credentials, k -> new ReentrantLock());

        synchronized (lock) {
            cachedToken = getAppTokenFromCache(credentials);
            if (cachedToken != null) {
                return cachedToken;
            }

            // fetch token
            ApiContext authContext = new ApiContext(credentials);

            GetTokenApi req = new GetTokenApi();
            GetTokenResult resp = client.execute(req, authContext);

            // save token to cache
            LocalDateTime expiredAt = DateUtil.toLocalDateTime(resp.getAccessTokenTokenExpired());
            Pair<String, LocalDateTime> tokenInfo = new Pair<>(resp.getAccessToken(), expiredAt);
            appTokens.put(credentials, tokenInfo);

            return resp.getAccessToken();
        }

    }

}
