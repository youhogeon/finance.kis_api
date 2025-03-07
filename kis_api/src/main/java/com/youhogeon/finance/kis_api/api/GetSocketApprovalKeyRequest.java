package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.BodyCredentialsRequired;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RestApi(method = RestApi.Method.POST, path = "/oauth2/Approval")
@BodyCredentialsRequired
public class GetSocketApprovalKeyRequest implements Api<GetSocketApprovalKeyResponse> {

    @Body("grant_type")
    private String grantType = "client_credentials";

}