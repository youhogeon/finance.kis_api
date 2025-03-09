package com.youhogeon.finance.kis_api.api.rest.auth;


import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;

@Getter
public class GetTokenResult extends CommonRestResult {

    private String accessToken;
    private String tokenType;
    private long expiresIn;
    private String accessTokenTokenExpired;

}