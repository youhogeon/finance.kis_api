package com.youhogeon.finance.kis_api.api.rest.auth;


import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.api.annotation.Header;

import lombok.Getter;

@Getter
public class GetSocketApprovalKeyResult implements ApiResult {

    @Header("content-type")
    private String contentType;

    @Header("tr_id")
    private String trId;

    @Header("tr_cont")
    private String trCont;

    @Header("gt_uid")
    private String gtUid;

    private String approvalKey;

}