package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.BodyCredentialsRequired;
import com.youhogeon.finance.kis_api.api.annotation.Method;
import com.youhogeon.finance.kis_api.api.annotation.URL;

import lombok.NoArgsConstructor;

@URL(method = Method.POST, path = "/oauth2/revokeP")
@BodyCredentialsRequired
@NoArgsConstructor
public class RevokeTokenRequest implements Api<RevokeTokenResponse> {

}
