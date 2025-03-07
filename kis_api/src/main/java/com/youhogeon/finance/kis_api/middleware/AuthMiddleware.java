package com.youhogeon.finance.kis_api.middleware;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

import com.youhogeon.finance.kis_api.KisClient;
import com.youhogeon.finance.kis_api.api.annotation.BodyCredentialsRequired;
import com.youhogeon.finance.kis_api.api.annotation.HeaderCredentialsRequired;
import com.youhogeon.finance.kis_api.api.GetTokenRequest;
import com.youhogeon.finance.kis_api.api.GetTokenResponse;
import com.youhogeon.finance.kis_api.client.NetworkRequest;
import com.youhogeon.finance.kis_api.config.Configuration;
import com.youhogeon.finance.kis_api.config.Credentials;
import com.youhogeon.finance.kis_api.context.ApiContext;
import com.youhogeon.finance.kis_api.context.ApiData;
import com.youhogeon.finance.kis_api.util.CredentialsUtil;
import com.youhogeon.finance.kis_api.util.DateUtil;
import com.youhogeon.finance.kis_api.util.Pair;

public class AuthMiddleware implements Middleware {

    private final ConcurrentMap<Credentials, Pair<String, LocalDateTime>> appTokens = new ConcurrentHashMap<>();
    private final ConcurrentMap<Credentials, ReentrantLock> locks = new ConcurrentHashMap<>();

    @Override
    public void before(KisClient client, ApiContext context) {
        NetworkRequest request = context.getRequest();

        ApiData apiData = context.getApiData();
        Credentials credentials = client.getConfig().getCredentials();

        boolean maskCredentials = client.getConfig().isMaskCredentials();

        String[] maskingKeys = new String[] { "appkey", "appsecret", "secretkey", "authorization", "approval_key" };

        if (apiData.hasAnnotation(BodyCredentialsRequired.class)) {
            Map<String, Object> body = request.getBody();

            body.put("appkey", credentials.getAppKey());
            body.put("appsecret", credentials.getAppSecret());
            body.put("secretkey", credentials.getAppSecret());
            // body.put("token", credentials.getAppToken()); // not required for now

            if (maskCredentials) {
                request.setBody(CredentialsUtil.maskMap(body, maskingKeys));
            }
        }

        if (apiData.hasAnnotation(HeaderCredentialsRequired.class)) {
            Map<String, Object> headers = request.getHeaders();
            String appToken = getAppToken(client, context);

            headers.put("appkey", credentials.getAppKey());
            headers.put("appsecret", credentials.getAppSecret());
            headers.put("authorization", "Bearer " + appToken);
            headers.put("approval_key", credentials.getApprovalKey());

            if (maskCredentials) {
                request.setHeaders(CredentialsUtil.maskMap(headers, maskingKeys));
            }
        }
    }

    @Override
    public void after(KisClient client, ApiContext context) {

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

            GetTokenRequest req = new GetTokenRequest();
            GetTokenResponse resp = client.execute(req, authContext);

            // save token to cache
            LocalDateTime expiredAt = DateUtil.toLocalDateTime(resp.getAccessTokenTokenExpired());
            Pair<String, LocalDateTime> tokenInfo = new Pair<>(resp.getAccessToken(), expiredAt);
            appTokens.put(credentials, tokenInfo);

            return resp.getAccessToken();
        }

    }

}
