package com.youhogeon.finance.kis_api.api;


import lombok.Getter;

@Getter
public class GetTokenResponse extends CommonRestResponse {

    private String accessToken;
    private String tokenType;
    private long expiresIn;
    private String accessTokenTokenExpired;

}