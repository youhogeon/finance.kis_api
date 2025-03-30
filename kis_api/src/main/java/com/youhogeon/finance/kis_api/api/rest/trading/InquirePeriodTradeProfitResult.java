package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonPageableRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquirePeriodTradeProfitResult extends CommonPageableRestResult<InquirePeriodTradeProfitResult> {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 연속조회키100 */
    private String ctxAreaNk100;

    /** 연속조회검색조건100 */
    private String ctxAreaFk100;

    /** 응답상세 */
    private Output1[] output1;

    /** 응답상세2 */
    private Output2 output2;

    @Getter
    @ToString
    public static class Output1 {

        /** 매매일자 */
        private String tradDt;

        /** 상품번호 (종목번호(뒤 6자리만 해당)) */
        private String pdno;

        /** 상품명 */
        private String prdtName;

        /** 매매구분명 */
        private String tradDvsnName;

        /** 대출일자 */
        private String loanDt;

        /** 보유수량 */
        private String hldgQty;

        /** 매입단가 */
        private String pchsUnpr;

        /** 매수수량 */
        private String buyQty;

        /** 매수금액 */
        private String buyAmt;

        /** 매도가격 */
        private String sllPric;

        /** 매도수량 */
        private String sllQty;

        /** 매도금액 */
        private String sllAmt;

        /** 실현손익 */
        private String rlztPfls;

        /** 손익률 */
        private String pflsRt;

        /** 수수료 */
        private String fee;

        /** 제세금 */
        private String tlTax;

        /** 대출이자 */
        private String loanInt;
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
        private String buyqtySmtl;

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

        /** 총실현손익 */
        private String totRlztPfls;

        /** 대출이자 */
        private String loanInt;

        /** 총수익률 */
        private String totPftrt;
    }

}
