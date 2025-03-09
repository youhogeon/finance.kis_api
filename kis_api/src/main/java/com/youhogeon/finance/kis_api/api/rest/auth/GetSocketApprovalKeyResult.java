package com.youhogeon.finance.kis_api.api.rest.auth;


import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;

@Getter
public class GetSocketApprovalKeyResult extends CommonRestResult {

    private String approvalKey;

}