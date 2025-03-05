package com.youhogeon.finance.kis_api.middleware;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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

    private Map<Credentials, Pair<String, LocalDateTime>> appTokens = new HashMap<>();

    @Override
    public void before(KisClient client, ApiData api, HttpClientRequest request, Credentials credentials) {
        if (api.isBodyCredentialsRequired()) {
            MaskingHashMap<String, Object> body = MaskingHashMap.from(request.getBody());

            body.put("appkey", credentials.getAppKey());
            body.putWithMasking("appsecret", credentials.getAppSecret());
            body.putWithMasking("token", credentials.getAppToken());

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

    private String getAppToken(KisClient client, Credentials credentials) {
        if (credentials.getAppToken() != null) {
            return credentials.getAppToken();
        }

        if (appTokens.containsKey(credentials)) {
            Pair<String, LocalDateTime> tokenInfo = appTokens.get(credentials);

            LocalDateTime accessTokenExpired = tokenInfo.getSecond();

            if (accessTokenExpired.isAfter(LocalDateTime.now().minusMinutes(1))) {
                return tokenInfo.getFirst();
            }
        }

        GetTokenRequest req = new GetTokenRequest();
        GetTokenResponse resp = client.execute(req, credentials);

        LocalDateTime expiredAt = DateUtil.toLocalDateTime(resp.getAccessTokenTokenExpired());

        Pair<String, LocalDateTime> tokenInfo = new Pair<>(resp.getAccessToken(), expiredAt);

        appTokens.put(credentials, tokenInfo);

        return resp.getAccessToken();
    }

}
