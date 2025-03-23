package com.youhogeon.finance.kis_api.config;

import java.util.Map;

public class SimpleCredentialsSelector implements CredentialsSelectionStrategy {

    @Override
    public Credentials getCredentials(Map<String, Credentials> credentials) {
        if (credentials.isEmpty()) {
            throw new IllegalArgumentException("Credentials not found");
        }

        return credentials.values().iterator().next();
    }

    @Override
    public Credentials getCredentials(Map<String, Credentials> credentials, String name) {
        if (!credentials.containsKey(name)) {
            throw new IllegalArgumentException("Credentials not found: " + name);
        }

        return credentials.get(name);
    }

}
