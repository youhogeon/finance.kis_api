package com.youhogeon.finance.kis_api.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import com.youhogeon.finance.kis_api.middleware.Middleware;

/**
 * API 설정
 */
public class Configuration {

    /**
     * API 호스트 주소
     */
    @Getter
    @Setter
    private String apiHost = "https://openapi.koreainvestment.com:9443";

    /**
     * 로깅 시 credential 정보를 마스킹할지 여부
     */
    @Getter
    @Setter
    private boolean maskCredentials = true;

    private Map<String, Credentials> credentials = new HashMap<>();
    private CredentialsSelectionStrategy credentialsSelector = new SimpleCredentialsSelector();

    private List<Middleware> middlewares = new ArrayList<>();

    public void addCredentials(Credentials credentials) {
        String uuid = java.util.UUID.randomUUID().toString();

        this.addCredentials(uuid, credentials);
    }

    public void addCredentials(String name, Credentials credentials) {
        this.credentials.put(name, credentials);
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
