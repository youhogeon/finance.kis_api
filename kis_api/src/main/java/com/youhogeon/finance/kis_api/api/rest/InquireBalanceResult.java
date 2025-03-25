package com.youhogeon.finance.kis_api.api.rest;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireBalanceResult extends CommonRestResult {

    private String rtCd;
    private String msgCd;
    private String msg1;
    private Output1[] output1;
    private Output2[] output2;

    @Getter
    @ToString
    public static class Output1 {
        private String pdno;
        private String prdtName;
        private String tradDvsnName;
        private String bfdyBuyQty;
        private String bfdySllQty;
        private String thdtBuyQty;
        private String thdtSllQty;
        private String hldgQty;
        private String ordPsblQty;
        private String pchsAvgPric;
        private String pchsAmt;
        private String prpr;
        private String evluAmt;
        private String evluPflsAmt;
        private String evluPflsRt;
        private String evluErngRt;
        private String loanDt;
        private String loanAmt;
        private String stlnSlngChgs;
        private String expdDt;
        private String flttRt;
        private String bfdyCprsIcdc;
        private String itemMgnaRtName;
        private String grtaRtName;
        private String sbstPric;
        private String stckLoanUnpr;
    }

    @Getter
    @ToString
    public static class Output2 {
        private String dncaTotAmt;
        private String nxdyExccAmt;
        private String prvsRcdlExccAmt;
        private String cmaEvluAmt;
        private String bfdyBuyAmt;
        private String thdtBuyAmt;
        private String nxdyAutoRdptAmt;
        private String bfdySllAmt;
        private String thdtSllAmt;
        private String d2AutoRdptAmt;
        private String bfdyTlexAmt;
        private String thdtTlexAmt;
        private String totLoanAmt;
        private String sctsEvluAmt;
        private String totEvluAmt;
        private String nassAmt;
        private String fncgGldAutoRdptYn;
        private String pchsAmtSmtlAmt;
        private String evluAmtSmtlAmt;
        private String evluPflsSmtlAmt;
        private String totStlnSlngChgs;
        private String bfdyTotAsstEvluAmt;
        private String asstIcdcAmt;
        private String asstIcdcErngRt;
    }

}
