package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.AppKeyAndSecretRequired;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Method;
import com.youhogeon.finance.kis_api.api.annotation.URL;

import lombok.Builder;
import lombok.Setter;

@URL(method = Method.POST, path = "/oauth2/tokenP")
@AppKeyAndSecretRequired
@Builder
@Setter
public class GetTokenRequest implements Api<GetTokenResponse> {

    @Header("grant_type")
    private String grantType;

}