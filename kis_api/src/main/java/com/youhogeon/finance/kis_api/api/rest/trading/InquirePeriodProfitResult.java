package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonPageableRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquirePeriodProfitResult extends CommonPageableRestResult<InquirePeriodProfitResult> {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 (배열) */
    private Output1[] output1;

    /** 응답상세2 (단건) */
    private Output2 output2;

    @Getter
    @ToString
    public static class Output1 {

        /** 매매일자 */
        private String tradDt;

        /** 매수금액 */
        private String buyAmt;

        /** 매도금액 */
        private String sllAmt;

        /** 실현손익 */
        private String rlztPfls;

        /** 수수료 */
        private String fee;

        /** 대출이자 */
        private String loanInt;

        /** 제세금 */
        private String tlTax;

        /** 손익률 */
        private String pflsRt;

        /** 매도수량1 */
        private String sllQty1;

        /** 매수수량1 */
        private String buyQty1;
    }

    @Getter
    @ToString
    public static class Output2 {

        /** 매도수량합계 */
        private String sllQtySmtl;

        /** 매도거래금액합계 */
        private String sllTrAmtSmtl;

        /** 매도수수료합계 */
        private String sllFeeSmtl;

        /** 매도제세금합계 */
        private String sllTltxSmtl;

        /** 매도정산금액합계 */
        private String sllExccAmtSmtl;

        /** 매수수량합계 */
        private String buyQtySmtl;

        /** 매수거래금액합계 */
        private String buyTrAmtSmtl;

        /** 매수수수료합계 */
        private String buyFeeSmtl;

        /** 매수제세금합계 */
        private String buyTaxSmtl;

        /** 매수정산금액합계 */
        private String buyExccAmtSmtl;

        /** 총수량 */
        private String totQty;

        /** 총거래금액 */
        private String totTrAmt;

        /** 총수수료 */
        private String totFee;

        /** 총제세금 */
        private String totTltx;

        /** 총정산금액 */
        private String totExccAmt;

        /**
         * 총실현손익
         * HTS[0856] 기간별 매매손익 '일별' 화면 우측 하단 '총손익률' 항목은
         * 기간별매매손익현황조회(TTTC8715R) > output2 > tot_pftrt(총수익률) 으로 확인 가능
         */
        private String totRlztPfls;

        /** 대출이자 */
        private String loanInt;
    }


}
