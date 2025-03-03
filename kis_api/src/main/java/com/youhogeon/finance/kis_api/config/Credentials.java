package com.youhogeon.finance.kis_api.config;

import lombok.Data;

/**
 * API 인증 정보
 */
@Data
public class Credentials {

    private String appKey;
    private String appSecret;

    private String appToken;

    private int restLimitPerSecond = 20;
    private int socketLimitPerSecond = 41;

    public Credentials(String apiKey, String apiSecret) {
        this(apiKey, apiSecret, null);
    }

    public Credentials(String apiKey, String apiSecret, String apiToken) {
        this.appKey = apiKey;
        this.appSecret = apiSecret;
        this.appToken = apiToken;
    }

}
