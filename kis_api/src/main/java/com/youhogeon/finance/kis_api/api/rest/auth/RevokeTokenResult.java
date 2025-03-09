package com.youhogeon.finance.kis_api.api.rest.auth;

import com.youhogeon.finance.kis_api.api.ApiResult;

import lombok.Getter;

@Getter
public class RevokeTokenResult implements ApiResult {

    private String code;
    private String message;

}
