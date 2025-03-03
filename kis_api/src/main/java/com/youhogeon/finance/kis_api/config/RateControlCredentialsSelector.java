package com.youhogeon.finance.kis_api.config;

import java.util.Map;

import com.youhogeon.finance.kis_api.util.RateLimiter;

/**
 * RateControlCredentialsSelector
 *
 * 임시 구현. getCredentials가 유량 제어되는게 아니라 network request가 유량 제어되어야 함. 수정 필요.
 */
public class RateControlCredentialsSelector implements CredentialsSelectionStrategy {

    private Map<String, RateLimiter> rateLimiters;

    private synchronized RateLimiter getRateLimiter(String name, Credentials credentials) {
        RateLimiter rateLimiter = rateLimiters.getOrDefault(credentials, null);

        if (rateLimiter != null) {
            return rateLimiter;
        }

        rateLimiter = new RateLimiter(credentials.getRestLimitPerSecond());
        rateLimiters.put(name, rateLimiter);

        return rateLimiter;
    }

    @Override
    public Credentials getCredentials(Map<String, Credentials> credentials) {
        if (credentials.isEmpty()) {
            throw new IllegalArgumentException("Credentials not found");
        }

        String name = null;
        long minWateTime = Long.MAX_VALUE;

        for (Map.Entry<String, Credentials> c : credentials.entrySet()) {
            RateLimiter rateLimiter = getRateLimiter(c.getKey(), c.getValue());

            try {
                rateLimiter.acquireWithoutWaiting();
            } catch (RuntimeException e) {
                long waitTime = rateLimiter.getWaitTime();

                if (waitTime < minWateTime) {
                    minWateTime = waitTime;
                    name = c.getKey();
                }

                continue;
            }

            return c.getValue();
        }

        Credentials c = credentials.get(name);
        RateLimiter rateLimiter = getRateLimiter(name, c);

        rateLimiter.acquire();

        return c;
    }

    @Override
    public Credentials getCredentials(Map<String, Credentials> credentials, String name) {
        if (!credentials.containsKey(name)) {
            throw new IllegalArgumentException("Credentials not found: " + name);
        }

        Credentials c = credentials.get(name);

        RateLimiter rateLimiter = getRateLimiter(name, c);

        rateLimiter.acquire();

        return credentials.get(name);
    }

}
