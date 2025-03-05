package com.youhogeon.finance.kis_api.middleware;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

import com.youhogeon.finance.kis_api.KisClient;
import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.api.GetTokenRequest;
import com.youhogeon.finance.kis_api.api.GetTokenResponse;
import com.youhogeon.finance.kis_api.client.ApiData;
import com.youhogeon.finance.kis_api.client.http.HttpClientRequest;
import com.youhogeon.finance.kis_api.client.http.HttpClientResponse;
import com.youhogeon.finance.kis_api.config.Credentials;
import com.youhogeon.finance.kis_api.util.DateUtil;
import com.youhogeon.finance.kis_api.util.MaskingHashMap;
import com.youhogeon.finance.kis_api.util.Pair;

public class AuthMiddleware implements Middleware {

    private final ConcurrentMap<Credentials, Pair<String, LocalDateTime>> appTokens = new ConcurrentHashMap<>();
    private final ConcurrentMap<Credentials, ReentrantLock> locks = new ConcurrentHashMap<>();

    @Override
    public void before(KisClient client, ApiData api, HttpClientRequest request, Credentials credentials) {
        if (api.isBodyCredentialsRequired()) {
            MaskingHashMap<String, Object> body = MaskingHashMap.from(request.getBody());

            body.put("appkey", credentials.getAppKey());
            body.putWithMasking("appsecret", credentials.getAppSecret());
            // body.putWithMasking("token", credentials.getAppToken()); // not required for now

            request.setBody(body);
        }

        if (api.isHeaderCredentialsRequired()) {
            MaskingHashMap<String, Object> headers = MaskingHashMap.from(request.getHeaders());

            headers.put("appKey", credentials.getAppKey());
            headers.putWithMasking("appSecret", credentials.getAppSecret());
            headers.putWithMasking("authorization", "Bearer " + getAppToken(client, credentials));

            request.setHeaders(headers);
        }
    }

    @Override
    public void after(KisClient client, ApiData api, HttpClientResponse response, ApiResult result, Credentials credentials) {

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

    private String getAppToken(KisClient client, Credentials credentials) {
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
            GetTokenRequest req = new GetTokenRequest();
            GetTokenResponse resp = client.execute(req, credentials);

            // save token to cache
            LocalDateTime expiredAt = DateUtil.toLocalDateTime(resp.getAccessTokenTokenExpired());
            Pair<String, LocalDateTime> tokenInfo = new Pair<>(resp.getAccessToken(), expiredAt);
            appTokens.put(credentials, tokenInfo);

            return resp.getAccessToken();
        }

    }

}
