package com.youhogeon.finance.kis_api.config;

import java.util.Map;

public class SimpleCredentialsSelector implements CredentialsSelectionStrategy {

    private volatile Map<String, Credentials> credentials;

    @Override
    public void setCredentials(Map<String, Credentials> credentials) {
        this.credentials = credentials;
    }

    @Override
    public Credentials getCredentials() {
        if (credentials.isEmpty()) {
            throw new IllegalArgumentException("Credentials not found");
        }

        return credentials.values().iterator().next();
    }

    @Override
    public Credentials getCredentials(String name) {
        if (!credentials.containsKey(name)) {
            throw new IllegalArgumentException("Credentials not found: " + name);
        }

        return credentials.get(name);
    }

}
