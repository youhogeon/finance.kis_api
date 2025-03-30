package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquirePsblSellResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output1 output1;

    @Getter
    @ToString
    public static class Output1 {

        /** 상품번호 */
        private String pdno;

        /** 상품명 */
        private String prdtName;

        /** 매수수량 */
        private String buyQty;

        /** 매도수량 */
        private String sllQty;

        /** 잔고수량 */
        private String cblcQty;

        /** 비저축수량 */
        private String nsvgQty;

        /** 주문가능수량 */
        private String ordPsblQty;

        /** 매입평균가격 */
        private String pchsAvgPric;

        /** 매입금액 */
        private String pchsAmt;

        /** 현재가 */
        private String nowPric;

        /** 평가금액 */
        private String evluAmt;

        /** 평가손익금액 */
        private String evluPflsAmt;

        /** 평가손익율 */
        private String evluPflsRt;
    }

}
