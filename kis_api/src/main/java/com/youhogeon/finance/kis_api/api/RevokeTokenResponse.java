package com.youhogeon.finance.kis_api.api;

import lombok.Getter;

@Getter
public class RevokeTokenResponse implements ApiResponse {

    private String code;
    private String message;

}
