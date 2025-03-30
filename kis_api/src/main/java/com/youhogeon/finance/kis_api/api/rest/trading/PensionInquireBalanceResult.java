package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonPageableRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class PensionInquireBalanceResult extends CommonPageableRestResult<PensionInquireBalanceResult> {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 배열 */
    private Output1[] output1;

    /** 응답상세2 */
    private Output2 output2;

    @Getter
    @ToString
    public static class Output1 {

        /** 잔고구분명 */
        private String cblcDvsnName;

        /** 상품명 */
        private String prdtName;

        /** 상품번호 */
        private String pdno;

        /** 종목구분명 */
        private String itemDvsnName;

        /** 금일매수수량 */
        private String thdtBuyqty;

        /** 금일매도수량 */
        private String thdtSllQty;

        /** 보유수량 */
        private String hldgQty;

        /** 주문가능수량 */
        private String ordPsblQty;

        /** 매입평균가격 */
        private String pchsAvgPric;

        /** 매입금액 */
        private String pchsAmt;

        /** 현재가 */
        private String prpr;

        /** 평가금액 */
        private String evluAmt;

        /** 평가손익금액 */
        private String evluPflsAmt;

        /** 평가수익율 */
        private String evluErngRt;
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

        /** 금일매수금액 */
        private String thdtBuyAmt;

        /** 금일매도금액 */
        private String thdtSllAmt;

        /** 금일제비용금액 */
        private String thdtTlexAmt;

        /** 유가평가금액 */
        private String sctsEvluAmt;

        /** 총평가금액 */
        private String totEvluAmt;
    }

}
