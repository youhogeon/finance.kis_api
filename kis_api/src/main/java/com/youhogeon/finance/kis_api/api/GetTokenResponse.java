package com.youhogeon.finance.kis_api.api;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetTokenResponse implements ApiResponse {

    private String accessToken;
    private String tokenType;
    private long expiresIn;
    private String accessTokenTokenExpired;

}