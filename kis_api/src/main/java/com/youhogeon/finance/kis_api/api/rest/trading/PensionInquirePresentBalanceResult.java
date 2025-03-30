package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonPageableRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class PensionInquirePresentBalanceResult extends CommonPageableRestResult<PensionInquirePresentBalanceResult> {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세1 */
    private Output1[] output1;

    /** 응답상세2 */
    private Output2[] output2;

    @Getter
    @ToString
    public static class Output1 {

        /** 잔고구분 */
        private String cblcDvsn;

        /** 잔고구분명 */
        private String cblcDvsnName;

        /** 상품번호 */
        private String pdno;

        /** 상품명 */
        private String prdtName;

        /** 보유수량 */
        private String hldgQty;

        /** 매도가능수량 */
        private String slpsbQty;

        /** 매입평균가격 */
        private String pchsAvgPric;

        /** 평가손익금액 */
        private String evluPflsAmt;

        /** 평가손익율 */
        private String evluPflsRt;

        /** 현재가 */
        private String prpr;

        /** 평가금액 */
        private String evluAmt;

        /** 매입금액 */
        private String pchsAmt;

        /** 잔고비중 */
        private String cblcWeit;
    }

    @Getter
    @ToString
    public static class Output2 {

        /** 매입금액합계금액 */
        private String pchsAmtSmtlAmt;

        /** 평가금액합계금액 */
        private String evluAmtSmtlAmt;

        /** 평가손익합계금액 */
        private String evluPflsSmtlAmt;

        /** 매매손익합계 */
        private String tradPflsSmtl;

        /** 당일총손익금액 */
        private String thdtTotPflsAmt;

        /** 수익률 */
        private String pftrt;
    }

}
