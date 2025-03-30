package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class PensionInquirePsblOrderResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세1 */
    private Output output;

    @Getter
    @ToString
    public static class Output {

        /** 주문가능현금 */
        private String ordPsblCash;

        /** 재사용가능금액 */
        private String rusePsblAmt;

        /** 가능수량계산단가 */
        private String psblQtyCalcUnpr;

        /** 최대매수금액 */
        private String maxBuyAmt;

        /** 최대매수수량 */
        private String maxBuyQty;
    }

}
