package com.youhogeon.finance.kis_api.config;

import java.util.Map;

public interface CredentialsSelectionStrategy {

    public void setCredentials(Map<String, Credentials> credentials);

    public Credentials getCredentials();
    public Credentials getCredentials(String name);

}
