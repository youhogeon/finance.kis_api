package com.youhogeon.finance.kis_api.api.rest.auth;


import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.api.annotation.Header;

import lombok.Getter;

@Getter
public class GetSocketApprovalKeyResult implements ApiResult {

    @Header("content-type")
    private String contentType;

    @Header
    private String trId;

    @Header
    private String trCont;

    @Header
    private String gtUid;

    private String approvalKey;

}