package com.youhogeon.finance.kis_api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youhogeon.finance.kis_api.api.Api;
import com.youhogeon.finance.kis_api.api.ApiParser;
import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.client.http.HttpClient;
import com.youhogeon.finance.kis_api.client.http.HttpClientRequest;
import com.youhogeon.finance.kis_api.client.http.HttpClientResponse;
import com.youhogeon.finance.kis_api.client.http.JavaHttpClient;
import com.youhogeon.finance.kis_api.config.Configuration;
import com.youhogeon.finance.kis_api.config.Credentials;
import com.youhogeon.finance.kis_api.context.ApiData;
import com.youhogeon.finance.kis_api.exception.InvalidApiRequestException;
import com.youhogeon.finance.kis_api.exception.KisClientException;
import com.youhogeon.finance.kis_api.middleware.AuthMiddleware;
import com.youhogeon.finance.kis_api.middleware.Middleware;
import com.youhogeon.finance.kis_api.middleware.RateLimitingMiddleware;
import com.youhogeon.finance.kis_api.middleware.ResponseHeaderMiddleware;
import com.youhogeon.finance.kis_api.util.CredentialsUtil;
import com.youhogeon.finance.kis_api.util.JsonConverter;

import lombok.Getter;

public class KisClient {

    @Getter
    private Configuration config;

    private HttpClient httpClient = new JavaHttpClient();
    private List<Middleware> middlewares = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(KisClient.class);

    public KisClient(Configuration config) {
        logger.info("{} initializing...", this.getClass().getSimpleName());

        setConfig(config);

        middlewares.add(new AuthMiddleware());
        middlewares.add(new ResponseHeaderMiddleware());
        middlewares.add(new RateLimitingMiddleware());
        middlewares.addAll(config.getAllMiddlewares());

        logger.info("{} initialized successfully.", this.getClass().getSimpleName());
    }

    private void setConfig(Configuration config) {
        if (!config.isMaskCredentials()) {
            logger.warn("Credential masking is disabled. Be careful not to expose your credentials in logs.");
        }

        this.config = config;
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
        logger.debug("API Request begins [{}]", api.getClass().getSimpleName());

        try {
            return _execute(api, credentials);
        } catch (KisClientException e) {
            logger.error("API Request failed [{}] {}", api.getClass().getSimpleName(), e.getMessage());

            throw e;
        } catch (Exception e) {
            logger.error("API Request failed (Unknown Error) [{}] {}", api.getClass().getSimpleName(), e.getMessage());

            throw new KisClientException("Unknown error occurred.", e);
        }
    }

    public void close() {
        // nothing to do for now
    }

    private <T extends ApiResult> T _execute(Api<T> api, Credentials credentials) {
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
            throw new InvalidApiRequestException("Failed to get response from server. (" + e.getMessage() + ")");
        }

        String responseString = response.getBody();
        int statusCode = response.getStatusCode();

        if (logger.isDebugEnabled()) {
            String maskedResponseString = config.isMaskCredentials() ? CredentialsUtil.maskAccessToken(responseString) : responseString;

            logger.debug("API Request ends. [{}] {} -> ({}) {}", api.getClass().getSimpleName(), request, statusCode, maskedResponseString);
        }

        if (responseString == null) {
            throw new InvalidApiRequestException("Failed to get response from server. (no response)", statusCode);
        }

        if (statusCode != 200) {
            logger.error("API Response Error [{}] : Unexpected status code {}. {} -> {}", api.getClass().getSimpleName(), statusCode, request, responseString);

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
