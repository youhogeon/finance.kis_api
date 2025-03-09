package com.youhogeon.finance.kis_api.api.rest.auth;

import com.youhogeon.finance.kis_api.api.Api;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppKeyRequired;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppSecretRequired;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppTokenRequired;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@RestApi(method = RestApi.Method.POST, path = "/oauth2/revokeP")
@AppKeyRequired(location = AppKeyRequired.Location.BODY)
@AppSecretRequired(location = AppSecretRequired.Location.BODY)
@AppTokenRequired(location = AppTokenRequired.Location.BODY, key = "token")
public class RevokeTokenApi implements Api<RevokeTokenResult> {

}
