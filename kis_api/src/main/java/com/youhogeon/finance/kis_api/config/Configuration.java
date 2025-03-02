package com.youhogeon.finance.kis_api.config;

import java.util.HashMap;
import java.util.Map;

/**
 * API 설정
 */
public class Configuration {

    private Map<String, Credentials> credentials = new HashMap<>();

    public void addCredentials(String name, Credentials credentials) {
        this.credentials.put(name, credentials);
    }

    protected Map<String, Credentials> getAllCredentials() {
        return credentials;
    }

    protected Credentials getCredentials(String name) {
        if (!credentials.containsKey(name)) {
            throw new IllegalArgumentException("Credentials not found: " + name);
        }

        return credentials.get(name);
    }

}
