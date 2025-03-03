package com.youhogeon.finance.kis_api;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.youhogeon.finance.kis_api.api.Api;
import com.youhogeon.finance.kis_api.api.ApiResponse;
import com.youhogeon.finance.kis_api.api.ErrorResponse;
import com.youhogeon.finance.kis_api.api.GetTokenRequest;
import com.youhogeon.finance.kis_api.api.GetTokenResponse;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.client.ApiParser;
import com.youhogeon.finance.kis_api.client.http.HttpClient;
import com.youhogeon.finance.kis_api.client.http.HttpClientRequest;
import com.youhogeon.finance.kis_api.client.http.HttpClientResponse;
import com.youhogeon.finance.kis_api.client.http.JavaHttpClient;
import com.youhogeon.finance.kis_api.config.Configuration;
import com.youhogeon.finance.kis_api.config.Credentials;
import com.youhogeon.finance.kis_api.exception.InvalidApiRequestException;
import com.youhogeon.finance.kis_api.util.DateUtil;
import com.youhogeon.finance.kis_api.util.JsonConverter;
import com.youhogeon.finance.kis_api.util.Pair;
import com.youhogeon.finance.kis_api.util.ReflectionUtil;

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

    private <T extends ApiResponse> T execute(Api<T> api, Credentials credentials) {
        HttpClientRequest request = makeRequest(api, credentials);
        Class<T> responseClass = getGenericType(api);

        HttpClientResponse response = null;

        try {
            response = this.httpClient.execute(request);
        } catch (IOException e) {
            throw new InvalidApiRequestException("Failed to get response from server. (Exception: " + e.getMessage() + ")");
        }

        String responseString = response.getBody();
        int statusCode = response.getStatusCode();

        System.out.println(responseString);

        if (responseString == null) {
            throw new InvalidApiRequestException("Failed to get response from server. (no response, status code: " + statusCode + ")");
        }

        if (statusCode != 200) {
            ErrorResponse errorResponse = JsonConverter.fromJson(responseString, ErrorResponse.class);

            throw new InvalidApiRequestException(errorResponse.getErrorDescription(), errorResponse.getErrorCode());
        }

        T responseObj = JsonConverter.fromJson(responseString, responseClass);

        injectHeaders(responseObj, response);

        return responseObj;
    }

    private <T extends ApiResponse> void injectHeaders(T responseObj, HttpClientResponse response) {
        Map<String, List<String>> allHeaders = response.getHeaders();
        Map<String, String> headers = new HashMap<>();

        for (String key : allHeaders.keySet()) {
            List<String> value = allHeaders.get(key);

            if (value.isEmpty() || value.size() > 1) {
                continue;
            }

            headers.put(key, value.get(0));
        }

        Field[] fields = ReflectionUtil.getAllFields(responseObj.getClass());

        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(Header.class);

            if (annotation == null) {
                continue;
            }

            String key = ((Header) annotation).value();

            if (headers.containsKey(key)) {
                try {
                    field.setAccessible(true);
                    field.set(responseObj, headers.get(key));
                } catch (IllegalAccessException e) {
                    continue;
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    private <T extends ApiResponse> Class<T> getGenericType(Api<T> api) {
        Type[] genericInterfaces = api.getClass().getGenericInterfaces();
        ParameterizedType parameterizedType = (ParameterizedType) genericInterfaces[0];

        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    private <T extends ApiResponse> HttpClientRequest makeRequest(Api<T> api, Credentials credentials) {
        ApiParser parser = new ApiParser(api);

        String method = parser.getMethod();
        String url = parser.getUrlPath();
        Map<String, Object> body = parser.getBody();
        Map<String, Object> headers = parser.getHeaders();
        Map<String, Object> parameters = parser.getParameters();

        if (parser.isBodyCredentialsRequired()) {
            body.put("appkey", credentials.getAppKey());
            body.put("appsecret", credentials.getAppSecret());
            body.put("token", credentials.getAppToken());
        } else if (!parser.isNoCredentialsRequired()) {
            headers.put("appKey", credentials.getAppKey());
            headers.put("appSecret", credentials.getAppSecret());
            headers.put("authorization", "Bearer " + getAppToken(credentials));
        }

        HttpClientRequest request = HttpClientRequest
                                        .builder()
                                        .method(method)
                                        .url(url)
                                        .body(body)
                                        .headers(headers)
                                        .parameters(parameters)
                                        .build();

        return request;
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

}
