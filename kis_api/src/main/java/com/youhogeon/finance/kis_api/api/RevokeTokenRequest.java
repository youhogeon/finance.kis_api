package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.RestApi;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@RestApi(method = RestApi.Method.POST, path = "/oauth2/revokeP")
public class RevokeTokenRequest implements Api<RevokeTokenResponse> {

}
