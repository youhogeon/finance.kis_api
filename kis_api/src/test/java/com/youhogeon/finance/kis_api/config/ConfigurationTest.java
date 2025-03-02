package com.youhogeon.finance.kis_api.config;

import org.junit.jupiter.api.Test;

public class ConfigurationTest {

    @Test
    public void testAddCredentials() {
        Configuration config = new Configuration();
        Credentials credentials = Credentials.builder()
            .apiKey("myApiKey")
            .apiSecret("myApiSecret")
            .build();

        config.addCredentials("myCredentials", credentials);


        assert(config.getAllCredentials().get("myCredentials").equals(credentials));
        assert(config.getCredentials("myCredentials").equals(credentials));

        try {
            config.getCredentials("notExist");
            assert(false);
        } catch (IllegalArgumentException e) {
            assert(true);
        }
    }

}
