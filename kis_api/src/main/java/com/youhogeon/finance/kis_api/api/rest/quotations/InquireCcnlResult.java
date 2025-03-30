package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireCcnlResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output1[] output1;

    @Getter
    @ToString
    public static class Output1 {

        /** 주식 체결 시간 */
        private String stckCntgHour;

        /** 주식 현재가 */
        private String stckPrpr;

        /** 전일 대비 */
        private String prdyVrss;

        /** 전일 대비 부호 */
        private String prdyVrssSign;

        /** 체결 거래량 */
        private String cntgVol;

        /** 당일 체결강도 */
        private String tdayRltv;

        /** 전일 대비율 */
        private String prdyCtrt;
    }

}
