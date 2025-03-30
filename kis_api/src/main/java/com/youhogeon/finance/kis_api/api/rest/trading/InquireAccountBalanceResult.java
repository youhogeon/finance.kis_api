package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireAccountBalanceResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output1[] output1;

    /** 응답상세2 */
    private Output2 output2;

    @Getter
    @ToString
    public static class Output1 {
        /** 매입금액 */
        private String pchsAmt;

        /** 평가금액 */
        private String evluAmt;

        /** 평가손익금액 */
        private String evluPflsAmt;

        /** 신용대출금액 */
        private String crdtLndAmt;

        /** 실제순자산금액 */
        private String realNassAmt;

        /** 전체비중율 */
        private String wholWeitRt;
    }

    @Getter
    @ToString
    public static class Output2 {
        /** 유가매입금액 */
        private String pchsAmtSmtl;

        /** 순자산총금액 */
        private String nassTotAmt;

        /** 대출금액합계 */
        private String loanAmtSmtl;

        /** 평가손익금액합계 */
        private String evluPflsAmtSmtl;

        /** 유가평가금액 */
        private String evluAmtSmtl;

        /** 총 자산금액 */
        private String totAsstAmt;

        /** 총대출금액총융자대출금액 */
        private String totLndaTotUlstLnda;

        /** CMA자동대출금액 */
        private String cmaAutoLoanAmt;

        /** 총담보대출금액 */
        private String totMglnAmt;

        /** 대주평가금액 */
        private String stlnEvluAmt;

        /** 신용융자금액 */
        private String crdtFncgAmt;

        /** OCL_APL대출금액 */
        private String oclAplLoanAmt;

        /** 질권설정금액 */
        private String pldgStupAmt;

        /** 외화평가총액 */
        private String frcrEvluTota;

        /** 총예수금액 */
        private String totDnclAmt;

        /** CMA평가금액 */
        private String cmaEvluAmt;

        /** 예수금액 */
        private String dnclAmt;

        /** 총대용금액 */
        private String totSbstAmt;

        /** 당일미수금액 */
        private String thdtRcvbAmt;

        /** 해외주식평가금액1 */
        private String ovrsStckEvluAmt1;

        /** 해외채권평가금액 */
        private String ovrsBondEvluAmt;

        /** MMFCMA담보대출금액 */
        private String mmfCmaMggeLoanAmt;

        /** 청약예수금액 */
        private String sbscDnclAmt;

        /** 공모주청약자금대출사용금액 */
        private String pbstSbscFndsLoanUseAmt;

        /** 기업신용공여대출금액 */
        private String etprCrdtGrntLoanAmt;
    }

}
