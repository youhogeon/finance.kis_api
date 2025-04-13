package com.youhogeon.finance.kis_api.config;

import org.junit.jupiter.api.Test;

public class CredentialsTest {

    @Test
    public void testAllArgsConstructor() {
        Credentials credentials = new Credentials("myApiKey", "myApiSecret");

        assert(credentials.getAppKey().equals("myApiKey"));
        assert(credentials.getAppSecret().equals("myApiSecret"));
    }

    @Test
    public void testEquals() {
        Credentials credentials1 = new Credentials("myApiKey", "myApiSecret");
        Credentials credentials2 = new Credentials("myApiKey", "myApiSecret");

        assert(credentials1.equals(credentials1));
        assert(credentials2.equals(credentials2));
        assert(!credentials1.equals(credentials2));

        credentials2 = new Credentials("yourApiKey", "yourApiSecret");
        assert(!credentials1.equals(credentials2));
    }

}
