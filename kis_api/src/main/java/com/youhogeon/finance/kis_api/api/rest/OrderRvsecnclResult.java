package com.youhogeon.finance.kis_api.api.rest;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class OrderRvsecnclResult extends CommonRestResult {

    private String rtCd;
    private String msgCd;
    private String msg1;
    private Output output;

    @Getter
    @ToString
    public static class Output {
        private String krxFwdgOrdOrgno;
        private String odno;
        private String ordTmd;
    }

}
