package com.youhogeon.finance.kis_api.config;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * API 설정
 */
public class Configuration {

    @Getter
    @Setter
    private String apiHost = "https://openapi.koreainvestment.com:9443";

    private Map<String, Credentials> credentials = new HashMap<>();
    private CredentialsSelectionStrategy credentialsSelector = new SimpleCredentialsSelector();

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

}
