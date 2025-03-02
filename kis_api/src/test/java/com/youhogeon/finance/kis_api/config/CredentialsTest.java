package com.youhogeon.finance.kis_api.config;

import org.junit.jupiter.api.Test;

public class CredentialsTest {

    @Test
    public void testBuilder() {
        Credentials credentials = Credentials.builder()
            .apiKey("myApiKey")
            .apiSecret("myApiSecret")
            .build();

        assert(credentials.getApiKey().equals("myApiKey"));
        assert(credentials.getApiSecret().equals("myApiSecret"));
    }

    @Test
    public void testAllArgsConstructor() {
        Credentials credentials = new Credentials("myApiKey", "myApiSecret");

        assert(credentials.getApiKey().equals("myApiKey"));
        assert(credentials.getApiSecret().equals("myApiSecret"));
    }

    @Test
    public void testEquals() {
        Credentials credentials1 = new Credentials("myApiKey", "myApiSecret");
        Credentials credentials2 = new Credentials("myApiKey", "myApiSecret");

        assert(credentials1.equals(credentials2));

        credentials2 = new Credentials("yourApiKey", "yourApiSecret");
        assert(!credentials1.equals(credentials2));
    }

}
