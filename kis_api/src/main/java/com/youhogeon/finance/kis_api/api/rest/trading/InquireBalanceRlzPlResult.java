package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonPageableRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireBalanceRlzPlResult extends CommonPageableRestResult<InquireBalanceRlzPlResult> {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output1[] output1;

    /** 응답상세2 */
    private Output2[] output2;

    @Getter
    @ToString
    public static class Output1 {

        /** 상품번호 (종목번호(뒷 6자리)) */
        private String pdno;

        /** 상품명 (종목명) */
        private String prdtName;

        /** 매매구분명 (매수매도구분) */
        private String tradDvsnName;

        /** 전일매수수량 */
        private String bfdyBuyQty;

        /** 전일매도수량 */
        private String bfdySllQty;

        /** 금일매수수량 */
        private String thdtBuyqty;

        /** 금일매도수량 */
        private String thdtSllQty;

        /** 보유수량 */
        private String hldgQty;

        /** 주문가능수량 */
        private String ordPsblQty;

        /** 매입평균가격 (매입금액 / 보유수량) */
        private String pchsAvgPric;

        /** 매입금액 */
        private String pchsAmt;

        /** 현재가 */
        private String prpr;

        /** 평가금액 */
        private String evluAmt;

        /** 평가손익금액 (평가금액 - 매입금액) */
        private String evluPflsAmt;

        /** 평가손익율 */
        private String evluPflsRt;

        /** 평가수익율 */
        private String evluErngRt;

        /** 대출일자 */
        private String loanDt;

        /** 대출금액 */
        private String loanAmt;

        /** 대주매각대금 (신용 거래에서 고객이 증권 회사로부터 대부받은 주식의 매각 대금) */
        private String stlnSlngChgs;

        /** 만기일자 */
        private String expdDt;

        /** 주식대출단가 */
        private String stckLoanUnpr;

        /** 전일대비증감 */
        private String bfdyCprsIcdc;

        /** 등락율 */
        private String flttRt;
    }

    @Getter
    @ToString
    public static class Output2 {

        /** 예수금총금액 */
        private String dncaTotAmt;

        /** 익일정산금액 */
        private String nxdyExccAmt;

        /** 가수도정산금액 */
        private String prvsRcdlExccAmt;

        /** CMA평가금액 */
        private String cmaEvluAmt;

        /** 전일매수금액 */
        private String bfdyBuyAmt;

        /** 금일매수금액 */
        private String thdtBuyAmt;

        /** 익일자동상환금액 */
        private String nxdyAutoRdptAmt;

        /** 전일매도금액 */
        private String bfdySllAmt;

        /** 금일매도금액 */
        private String thdtSllAmt;

        /** D+2자동상환금액 */
        private String d2AutoRdptAmt;

        /** 전일제비용금액 */
        private String bfdyTlexAmt;

        /** 금일제비용금액 */
        private String thdtTlexAmt;

        /** 총대출금액 */
        private String totLoanAmt;

        /** 유가평가금액 */
        private String sctsEvluAmt;

        /** 총평가금액 */
        private String totEvluAmt;

        /** 순자산금액 */
        private String nassAmt;

        /** 융자금자동상환여부 */
        private String fncgGldAutoRdptYn;

        /** 매입금액합계금액 */
        private String pchsAmtSmtlAmt;

        /** 평가금액합계금액 */
        private String evluAmtSmtlAmt;

        /** 평가손익합계금액 */
        private String evluPflsSmtlAmt;

        /** 총대주매각대금 */
        private String totStlnSlngChgs;

        /** 전일총자산평가금액 */
        private String bfdyTotAsstEvluAmt;

        /** 자산증감액 */
        private String asstIcdcAmt;

        /** 자산증감수익율 */
        private String asstIcdcErngRt;

        /** 실현손익 */
        private String rlztPfls;

        /** 실현수익율 */
        private String rlztErngRt;

        /** 실평가손익 */
        private String realEvluPfls;

        /** 실평가손익수익율 */
        private String realEvluPflsErngRt;
    }

}
