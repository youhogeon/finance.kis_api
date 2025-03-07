package com.youhogeon.finance.kis_api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youhogeon.finance.kis_api.api.Api;
import com.youhogeon.finance.kis_api.api.ApiParser;
import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.client.NetworkClient;
import com.youhogeon.finance.kis_api.client.NetworkRequest;
import com.youhogeon.finance.kis_api.client.NetworkResponse;
import com.youhogeon.finance.kis_api.client.http.HttpClient;
import com.youhogeon.finance.kis_api.client.http.HttpClientRequest;
import com.youhogeon.finance.kis_api.client.http.HttpClientResponse;
import com.youhogeon.finance.kis_api.client.http.JavaHttpClient;
import com.youhogeon.finance.kis_api.client.socket.JsrSocketClient;
import com.youhogeon.finance.kis_api.config.Configuration;
import com.youhogeon.finance.kis_api.config.Credentials;
import com.youhogeon.finance.kis_api.context.ApiContext;
import com.youhogeon.finance.kis_api.context.ApiData;
import com.youhogeon.finance.kis_api.exception.InvalidApiRequestException;
import com.youhogeon.finance.kis_api.exception.KisClientException;
import com.youhogeon.finance.kis_api.middleware.AuthMiddleware;
import com.youhogeon.finance.kis_api.middleware.Middleware;
import com.youhogeon.finance.kis_api.middleware.RateLimitingMiddleware;
import com.youhogeon.finance.kis_api.middleware.ResponseHeaderMiddleware;
import com.youhogeon.finance.kis_api.util.JsonConverter;

import lombok.Getter;

public class KisClient {

    @Getter
    private Configuration config;

    private List<Middleware> middlewares = new ArrayList<>();

    NetworkClient[] clients;

    private static final Logger logger = LoggerFactory.getLogger(KisClient.class);

    public KisClient(Configuration config) {
        logger.info("{} initializing...", this.getClass().getSimpleName());

        setConfig(config);

        middlewares.add(new AuthMiddleware());
        middlewares.add(new ResponseHeaderMiddleware());
        middlewares.add(new RateLimitingMiddleware());
        middlewares.addAll(config.getAllMiddlewares());

        clients = new NetworkClient[] {
            new JavaHttpClient(config),
            new JsrSocketClient(config)
        };

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
        ApiContext context = new ApiContext(credentials);

        return execute(api, context);
    }

    public <T extends ApiResult> T execute(Api<T> api, String credentialsName) {
        Credentials credentials = config.getCredentials(credentialsName);
        ApiContext context = new ApiContext(credentials);

        return execute(api, context);
    }

    public <T extends ApiResult> T execute(Api<T> api, ApiContext context) {
        logger.debug("API Request begins [{}]", api.getClass().getSimpleName());

        try {
            return _execute(api, context);
        } catch (KisClientException e) {
            logger.error("API Request failed [{}] {}", api.getClass().getSimpleName(), e.getMessage());

            throw e;
        } catch (Exception e) {
            logger.error("API Request failed (Unknown Error) [{}] {}", api.getClass().getSimpleName(), e.getMessage());

            throw new KisClientException("Unknown error occurred.", e);
        }
    }

    public void close() {
        for (NetworkClient client : clients) {
            try {
                client.close();
            } catch (IOException e) {
                logger.error("Failed to close client. {}", e.getMessage());
            }
        }
    }

    private NetworkClient getClient(ApiData data) {
        for (NetworkClient client : clients) {
            if (client.isSupport(data)) {
                return client;
            }
        }

        throw new InvalidApiRequestException("No client supports the request.");
    }

    private <T extends ApiResult> T _execute(Api<T> api, ApiContext context) {
        ApiParser parser = new ApiParser(api);
        ApiData data = parser.parse();

        context.setApiData(data);

        NetworkClient client = getClient(data);
        NetworkRequest request = client.makeRequest(data);

        context.setRequest(request);

        for (Middleware middleware : middlewares) {
            middleware.before(this, context);
        }

        try {
            client.execute(context);
        } catch (IOException e) {
            throw new InvalidApiRequestException("Failed to get response from server. (" + e.getMessage() + ")");
        }

        NetworkResponse response = context.getResponse();
        String responseString = response.getBody();

        ApiResult result = JsonConverter.fromJson(responseString, data.getResponseClass());

        context.setResponse(response);
        context.setApiResult(result);

        for (Middleware middleware : middlewares) {
            middleware.after(this, context);
        }

        @SuppressWarnings("unchecked")
        T _result = (T)result;

        return _result;
    }

}
