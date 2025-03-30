package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class OrderCashResult extends CommonRestResult {

    /** 성공 실패 여부 */
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

        /** 거래소코드 */
        private String krxFwdgOrdOrgno;

        /** 주문번호 */
        private String odno;

        /** 주문시간 */
        private String ordTmd;
    }

}
