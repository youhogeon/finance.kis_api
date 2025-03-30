package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonPageableRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class PensionInquireDailyCcldResult extends CommonPageableRestResult<PensionInquireDailyCcldResult> {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세1 */
    private Output[] output;

    @Getter
    @ToString
    public static class Output {

        /** 주문채번지점번호 */
        private String ordGnoBrno;

        /** 매도매수구분코드 */
        private String sllBuyDvsnCd;

        /** 매매구분명 */
        private String tradDvsnName;

        /** 주문번호 */
        private String odno;

        /** 상품번호 */
        private String pdno;

        /** 상품명 */
        private String prdtName;

        /** 주문단가 */
        private String ordUnpr;

        /** 주문수량 */
        private String ordQty;

        /** 총체결수량 */
        private String totCcldQty;

        /** 미체결수량 */
        private String nccsQty;

        /** 주문구분코드 */
        private String ordDvsnCd;

        /** 주문구분명 */
        private String ordDvsnName;

        /** 원주문번호 */
        private String orgnOdno;

        /** 주문시각 */
        private String ordTmd;

        /** 대상고객구분명 */
        private String objtCustDvsnName;

        /** 매입평균가격 */
        private String pchsAvgPric;
    }

}
