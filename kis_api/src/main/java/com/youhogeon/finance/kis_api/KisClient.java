package com.youhogeon.finance.kis_api;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.youhogeon.finance.kis_api.api.Api;
import com.youhogeon.finance.kis_api.api.ApiResponse;
import com.youhogeon.finance.kis_api.api.GetTokenRequest;
import com.youhogeon.finance.kis_api.api.GetTokenResponse;
import com.youhogeon.finance.kis_api.client.ApiParser;
import com.youhogeon.finance.kis_api.client.http.HttpClient;
import com.youhogeon.finance.kis_api.client.http.HttpClientRequest;
import com.youhogeon.finance.kis_api.client.http.JavaHttpClient;
import com.youhogeon.finance.kis_api.config.Configuration;
import com.youhogeon.finance.kis_api.config.Credentials;
import com.youhogeon.finance.kis_api.util.DateUtil;
import com.youhogeon.finance.kis_api.util.Pair;

public class KisClient {

    private Configuration config;
    private HttpClient httpClient;

    private Map<Credentials, Pair<String, LocalDateTime>> appTokens = new HashMap<>();

    public KisClient(Configuration config) {
        this.config = config;
        this.httpClient = new JavaHttpClient(config.getApiHost());
    }

    public <T extends ApiResponse> T execute(Api<T> api) {
        Credentials credentials = config.getCredentials();

        return execute(api, credentials);
    }

    public <T extends ApiResponse> T execute(Api<T> api, String credentialsName) {
        Credentials credentials = config.getCredentials(credentialsName);

        return execute(api, credentials);
    }

    private String getAppToken(Credentials credentials) {
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
        GetTokenResponse resp = execute(req, credentials);

        LocalDateTime expiredAt = DateUtil.toLocalDateTime(resp.getAccessTokenTokenExpired());

        Pair<String, LocalDateTime> tokenInfo = new Pair<>(resp.getAccessToken(), expiredAt);

        appTokens.put(credentials, tokenInfo);

        return resp.getAccessToken();
    }

    private <T extends ApiResponse> T execute(Api<T> api, Credentials credentials) {
        ApiParser parser = new ApiParser(api);

        String method = parser.getMethod();
        String url = parser.getUrlPath();
        Map<String, Object> body = parser.getBody();
        Map<String, Object> headers = parser.getHeaders();
        Map<String, Object> parameters = parser.getParameters();

        if (parser.isBodyCredentialsRequired()) {
            body.put("appkey", credentials.getAppKey());
            body.put("appsecret", credentials.getAppSecret());
        } else if (!parser.isNoCredentialsRequired()) {
            headers.put("appKey", credentials.getAppKey());
            headers.put("appSecret", credentials.getAppSecret());
            headers.put("authorization", "Bearer " + getAppToken(credentials));
        }

        HttpClientRequest request = HttpClientRequest.builder()
                                        .method(method)
                                        .url(url)
                                        .body(body)
                                        .headers(headers)
                                        .parameters(parameters)
                                        .build();

        Class<T> responseClass = getGenericType(api);

        T result = this.httpClient.execute(request, responseClass);

        return result;
    }

    @SuppressWarnings("unchecked")
    private <T extends ApiResponse> Class<T> getGenericType(Api<T> api) {
        Type[] genericInterfaces = api.getClass().getGenericInterfaces();
        ParameterizedType parameterizedType = (ParameterizedType) genericInterfaces[0];

        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

}
