package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.BodyCredentialsRequired;
import com.youhogeon.finance.kis_api.api.annotation.Method;
import com.youhogeon.finance.kis_api.api.annotation.URL;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@URL(method = Method.POST, path = "/oauth2/tokenP")
@BodyCredentialsRequired
@NoArgsConstructor
@AllArgsConstructor
public class GetTokenRequest implements Api<GetTokenResponse> {

    @Body("grant_type")
    private String grantType = "client_credentials";

}