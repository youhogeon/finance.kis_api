package com.youhogeon.finance.kis_api.config;

import java.util.Map;

public interface CredentialsSelectionStrategy {

    public Credentials getCredentials(Map<String, Credentials> credentials);
    public Credentials getCredentials(Map<String, Credentials> credentials, String name);

}
