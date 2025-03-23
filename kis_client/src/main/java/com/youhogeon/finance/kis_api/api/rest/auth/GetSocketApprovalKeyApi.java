package com.youhogeon.finance.kis_api.api.rest.auth;

import com.youhogeon.finance.kis_api.api.Api;
import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppKeyRequired;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppSecretRequired;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RestApi(method = RestApi.Method.POST, path = "/oauth2/Approval")
@AppKeyRequired(location = AppKeyRequired.Location.BODY)
@AppSecretRequired(location = AppSecretRequired.Location.BODY, key="secretkey")
public class GetSocketApprovalKeyApi implements Api<GetSocketApprovalKeyResult> {

    @Header("content-type")
    private String contentType = "application/json; utf-8";

    @Body("grant_type")
    private String grantType = "client_credentials";

}