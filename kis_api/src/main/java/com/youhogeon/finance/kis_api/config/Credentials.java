package com.youhogeon.finance.kis_api.config;

import lombok.Data;

/**
 * API 인증 정보
 */
@Data
public class Credentials {

    private String apiKey;
    private String apiSecret;

    private String apiToken;

    private int restLimitPerSecond = 20;
    private int socketLimitPerSecond = 41;

    public Credentials(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public Credentials(String apiToken) {
        this.apiToken = apiToken;
    }

}
