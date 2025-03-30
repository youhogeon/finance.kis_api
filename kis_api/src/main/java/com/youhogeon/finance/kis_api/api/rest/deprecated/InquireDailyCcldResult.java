package com.youhogeon.finance.kis_api.api.rest.deprecated;

import com.youhogeon.finance.kis_api.api.rest.PageableApiResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireDailyCcldResult extends PageableApiResult<InquireDailyCcldResult> {

    private String rtCd;
    private String msgCd;
    private String msg1;
    private Output1[] output1;
    private Output2 output2;

    @Getter
    @ToString
    public static class Output1 {

        private String ordDt;
        private String ordGnoBrno;
        private String odno;
        private String orgnOdno;
        private String ordDvsnName;
        private String sllBuyDvsnCd;
        private String sllBuyDvsnCdName;
        private String pdno;
        private String prdtName;
        private String ordQty;
        private String ordUnpr;
        private String ordTmd;
        private String totCcldQty;
        private String avgPrvs;
        private String cnclYn;
        private String totCcldAmt;
        private String loanDt;
        private String ordrEmpno;
        private String ordDvsnCd;
        private String cncCfrmQty;
        private String rmnQty;
        private String rjctQty;
        private String ccldCndtName;
        private String inqrIpAddr;
        private String cpbcOrdpOrdRcitDvsnCd;
        private String cpbcOrdpInfmMthdDvsnCd;
        private String infmTmd;
        private String ctacTlno;
        private String prdtTypeCd;
        private String excgDvsnCd;
        private String cpbcOrdpMtrlDvsnCd;
        private String ordOrgno;
        private String rsvnOrdEndDt;
        private String excgIdDvsnCd;
        private String stpmCndtPric;
        private String stpmEfctOccrDtmd;

    }

    @Getter
    @ToString
    public static class Output2 {

        private String totOrdQty;
        private String totCcldQty;
        private String totCcldAmt;
        private String prsmTlexSmtl;
        private String pchsAvgPric;

    }

}