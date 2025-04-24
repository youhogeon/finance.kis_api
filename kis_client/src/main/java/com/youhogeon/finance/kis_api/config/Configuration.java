package com.youhogeon.finance.kis_api.config;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.youhogeon.finance.kis_api.middleware.Middleware;

import lombok.Getter;
import lombok.Setter;

/**
 * API 설정
 */
public class Configuration {

    /**
     * HTTP API 호스트 주소
     */
    @Getter
    @Setter
    private String httpHost = "https://openapi.koreainvestment.com:9443";

    /**
     * HTTP Timeout
     */
    @Getter
    @Setter
    private Duration httpTimeout = Duration.ofSeconds(10);

    /**
     * HTTP Timeout 재시도 횟수
     */
    @Getter
    @Setter
    private int httpTimeoutMaxRetries = 5;

    /**
     * Socket API 호스트 주소
     */
    @Getter
    @Setter
    private String socketHost = "ws://ops.koreainvestment.com:21000";

    /**
     * Socket Timeout
     */
    @Getter
    @Setter
    private Duration socketTimeout = Duration.ofSeconds(10);

    /**
     * 로깅 시 credential 정보를 마스킹할지 여부
     */
    @Getter
    @Setter
    private boolean maskCredentials = true;

    private Map<String, Credentials> credentials = new HashMap<>();
    private CredentialsSelectionStrategy credentialsSelector = new WeightedRoundRobinCredentialsSelector();

    private List<Middleware> middlewares = new ArrayList<>();

    public void addCredentials(Credentials credentials) {
        String uuid = java.util.UUID.randomUUID().toString();

        this.addCredentials(uuid, credentials);
    }

    public void addCredentials(String name, Credentials credentials) {
        this.credentials.put(name, credentials);
    }

    public int removeCredentials(String name) {
        return this.credentials.remove(name) != null ? 1 : 0;
    }

    public int removeCredentials(Credentials credentials) {
        int before = this.credentials.size();

        this.credentials.values().removeIf(c -> c.equals(credentials));

        int removed = before - this.credentials.size();

        return removed;
    }

    public void setCredentialsSelector(CredentialsSelectionStrategy credentialsSelector) {
        this.credentialsSelector = credentialsSelector;
    }

    public Map<String, Credentials> getAllCredentials() {
        return credentials;
    }

    public Credentials getCredentials() {
        return credentialsSelector.getCredentials(credentials);
    }

    public Credentials getCredentials(String name) {
        return credentialsSelector.getCredentials(credentials, name);
    }

    public void addMiddleWare(Middleware middleware) {
        middlewares.add(middleware);
    }

    public List<Middleware> getAllMiddlewares() {
        return middlewares;
    }

}
