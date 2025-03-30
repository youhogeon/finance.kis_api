package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquirePsblOrderResult extends CommonRestResult {

    /** 성공 실패 여부 (0: 성공, 0 이외: 실패) */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output output;

    @Getter
    @ToString
    public static class Output {

        /** 주문가능현금 (예수금으로 계산된 주문가능금액) */
        private String ordPsblCash;

        /** 주문가능대용 */
        private String ordPsblSbst;

        /** 재사용가능금액 (전일/금일 매도대금으로 계산된 주문가능금액) */
        private String rusePsblAmt;

        /** 펀드환매대금 */
        private String fundRpchChgs;

        /** 가능수량계산단가 */
        private String psblQtyCalcUnpr;

        /** 미수없는매수금액 (미수를 사용하지 않으실 경우 확인) */
        private String nrcvbBuyAmt;

        /** 미수없는매수수량 (미수를 사용하지 않으실 경우 확인) */
        private String nrcvbBuyQty;

        /**
         * 최대매수금액 (미수를 사용하시는 경우 확인)
         * 특정 종목 전량매수 시 가능수량 확인 시 ORD_DVSN:01(시장가)로 지정 필수
         * 특정 주문구분(ex.IOC)으로 주문 시 주문 시와 동일한 주문구분 입력
         */
        private String maxBuyAmt;

        /**
         * 최대매수수량 (미수를 사용하시는 경우 확인)
         * 특정 종목 전량매수 시 가능수량 확인 시 ORD_DVSN:01(시장가)로 지정 필수
         * 특정 주문구분(ex.IOC)으로 주문 시 주문 시와 동일한 주문구분 입력
         */
        private String maxBuyQty;

        /** CMA평가금액 */
        private String cmaEvluAmt;

        /** 해외재사용금액원화 */
        private String ovrsReUseAmtWcrc;

        /** 주문가능외화금액원화 */
        private String ordPsblFrcrAmtWcrc;
    }

}
