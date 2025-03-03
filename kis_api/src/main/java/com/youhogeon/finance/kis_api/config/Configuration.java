package com.youhogeon.finance.kis_api.config;

import java.util.HashMap;
import java.util.Map;

/**
 * API 설정
 */
public class Configuration {

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

    protected Map<String, Credentials> getAllCredentials() {
        return credentials;
    }

    protected Credentials getCredentials() {
        return credentialsSelector.getCredentials(credentials);
    }

    protected Credentials getCredentials(String name) {
        return credentialsSelector.getCredentials(credentials, name);
    }

}
