package com.youhogeon.finance.kis_api.config;

import lombok.Getter;
import lombok.Setter;

/**
 * API 인증 정보
 */
@Getter
@Setter
public class Credentials {

    private String appKey;
    private String appSecret;

    private String accountNo;
    private String accountProductCode;

    /**
     * 앱 토큰 발급 요청 없이 기 발급받은 토큰 이용 시 사용
     */
    private String appToken;
    private String appTokenExpiredAt;

    private String approvalKey;

    /**
     * 초당 허용 요청 수 (한국투자증권에서 제공하는 유량)
     *
     * 한국투자증권에서 제공하는 유량은 초당 20회로 제한되어 있으나, 네트워크 레이턴시를 고려해 19회를 기본값으로 함
     */
    private int restLimitPerSecond = 19;

    /**
     * 소캣 허용 수신 수 (한국투자증권에서 제공하는 유량)
     *
     * 한국투자증권에서 제공하는 유량은 41 연결로 제한되어 있음
     */
    // private int socketLimitPerSecond = 41;

    public Credentials(String apiKey, String apiSecret) {
        this.appKey = apiKey;
        this.appSecret = apiSecret;
    }

    public Credentials(String apiKey, String apiSecret, String accountNo, String accountProductCode) {
       this.appKey = apiKey;
       this.appSecret = apiSecret;
       this.accountNo = accountNo;
       this.accountProductCode = accountProductCode;
    }

}
