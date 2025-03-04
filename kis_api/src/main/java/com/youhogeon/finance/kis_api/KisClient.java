package com.youhogeon.finance.kis_api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.youhogeon.finance.kis_api.api.Api;
import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.client.ApiData;
import com.youhogeon.finance.kis_api.client.ApiParser;
import com.youhogeon.finance.kis_api.client.http.HttpClient;
import com.youhogeon.finance.kis_api.client.http.HttpClientRequest;
import com.youhogeon.finance.kis_api.client.http.HttpClientResponse;
import com.youhogeon.finance.kis_api.client.http.JavaHttpClient;
import com.youhogeon.finance.kis_api.config.Configuration;
import com.youhogeon.finance.kis_api.config.Credentials;
import com.youhogeon.finance.kis_api.exception.InvalidApiRequestException;
import com.youhogeon.finance.kis_api.exception.KisClientException;
import com.youhogeon.finance.kis_api.middleware.AuthMiddleware;
import com.youhogeon.finance.kis_api.middleware.Middleware;
import com.youhogeon.finance.kis_api.middleware.ResponseHeaderMiddleware;
import com.youhogeon.finance.kis_api.util.JsonConverter;

public class KisClient {

    private Configuration config;
    private HttpClient httpClient;

    private List<Middleware> middlewares = new ArrayList<>();

    public KisClient(Configuration config) {
        this.config = config;
        this.httpClient = new JavaHttpClient();

        middlewares.add(new AuthMiddleware());
        middlewares.add(new ResponseHeaderMiddleware());
        middlewares.addAll(config.getAllMiddlewares());
    }

    public <T extends ApiResult> T execute(Api<T> api) {
        Credentials credentials = config.getCredentials();

        return execute(api, credentials);
    }

    public <T extends ApiResult> T execute(Api<T> api, String credentialsName) {
        Credentials credentials = config.getCredentials(credentialsName);

        return execute(api, credentials);
    }

    public <T extends ApiResult> T execute(Api<T> api, Credentials credentials) {
        try {
            return _execute(api, credentials);
        } catch (KisClientException e) {
            throw e;
        } catch (Exception e) {
            throw new KisClientException("Unknown error occurred. (" + e.getMessage() + ")", e);
        }
    }

    public <T extends ApiResult> T _execute(Api<T> api, Credentials credentials) {
        ApiParser parser = new ApiParser(api);
        ApiData data = parser.parse();

        HttpClientRequest request = HttpClientRequest.from(config.getApiHost(), data);

        for (Middleware middleware : middlewares) {
            middleware.before(this, data, request, credentials);
        }

        HttpClientResponse response = null;

        try {
            response = this.httpClient.execute(request);
        } catch (IOException e) {
            throw new InvalidApiRequestException("Failed to get response from server. (Exception: " + e.getMessage() + ")");
        }

        String responseString = response.getBody();
        int statusCode = response.getStatusCode();

        if (responseString == null) {
            throw new InvalidApiRequestException("Failed to get response from server. (no response)", statusCode);
        }

        if (statusCode != 200) {
            throw new InvalidApiRequestException(responseString, statusCode);
        }

        ApiResult result = JsonConverter.fromJson(responseString, data.getResponseClass());

        for (Middleware middleware : middlewares) {
            middleware.after(this, data, response, result, credentials);
        }

        @SuppressWarnings("unchecked")
        T _result = (T)result;

        return _result;
    }

}
