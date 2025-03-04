package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.Method;
import com.youhogeon.finance.kis_api.api.annotation.URL;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@URL(method = Method.POST, path = "/oauth2/revokeP")
public class RevokeTokenRequest implements Api<RevokeTokenResponse> {

}
