package com.youhogeon.finance.kis_api.middleware;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.youhogeon.finance.kis_api.KisClient;
import com.youhogeon.finance.kis_api.client.http.HttpClientRequest;
import com.youhogeon.finance.kis_api.config.Credentials;
import com.youhogeon.finance.kis_api.context.ApiContext;
import com.youhogeon.finance.kis_api.util.RateLimiter;

public class RateLimitingMiddleware implements Middleware {

    private final ConcurrentMap<Credentials, RateLimiter> rateLimiters = new ConcurrentHashMap<>();

    @Override
    public void afterInit(KisClient client, ApiContext context) {

    }

    @Override
    public void before(KisClient client, ApiContext context) {
        if (!(context.getRequest() instanceof HttpClientRequest)) {
            return;
        }

        Credentials credentials = context.getCredentials();

        int limit = credentials.getRestLimitPerSecond();
        rateLimiters.computeIfAbsent(credentials, key -> new RateLimiter(limit));

        RateLimiter limiter = rateLimiters.get(credentials);

        limiter.acquire(); // wait
    }

    @Override
    public void after(KisClient client, ApiContext context) {

    }

}
