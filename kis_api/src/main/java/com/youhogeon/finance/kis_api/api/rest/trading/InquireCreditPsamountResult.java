package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireCreditPsamountResult extends CommonRestResult {

    /** 성공 실패 여부 (0:성공, 0 이외: 실패) */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메시지 */
    private String msg1;

    /** 응답상세 */
    private Output1 output1;

    @Getter
    @ToString
    public static class Output1 {

        /** 주문가능현금 */
        private String ordPsblCash;

        /** 주문가능대용 */
        private String ordPsblSbst;

        /** 재사용가능금액 */
        private String rusePsblAmt;

        /** 펀드환매대금 */
        private String fundRpchChgs;

        /** 가능수량계산단가 */
        private String psblQtyCalcUnpr;

        /** 미수없는매수금액 */
        private String nrcvbBuyAmt;

        /** 미수없는매수수량 */
        private String nrcvbBuyQty;

        /** 최대매수금액 */
        private String maxBuyAmt;

        /** 최대매수수량 */
        private String maxBuyQty;

        /** CMA평가금액 */
        private String cmaEvluAmt;

        /** 해외재사용금액원화 */
        private String ovrsReUseAmtWcrc;

        /** 주문가능외화금액원화 */
        private String ordPsblFrcrAmtWcrc;
    }

}
