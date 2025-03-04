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

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        Credentials other = (Credentials)obj;

        return this.appKey.equals(other.appKey) && this.appSecret.equals(other.appSecret);
    }

    public int hashCode() {
        return appKey.hashCode() + appSecret.hashCode();
    }

}
