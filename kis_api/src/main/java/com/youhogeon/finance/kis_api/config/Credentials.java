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

    /**
     * 초당 허용 요청 수 (한국투자증권에서 제공하는 유량)
     *
     * 한국투자증권에서 제공하는 유량은 초당 20회로 제한되어 있으나, 네트워크 레이턴시를 고려해 19회를 기본값으로 함
     */
    private int restLimitPerSecond = 19;

    /**
     * 초당 소캣 허용 요청 수 (한국투자증권에서 제공하는 유량)
     *
     * 한국투자증권에서 제공하는 유량은 41 연결로 제한되어 있으나, 네트워크 레이턴시를 고려해 40을 기본값으로 함
     */
    private int socketLimitPerSecond = 40;

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
