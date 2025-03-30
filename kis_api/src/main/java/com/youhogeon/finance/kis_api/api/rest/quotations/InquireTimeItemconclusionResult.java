package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireTimeItemconclusionResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세1 (단일 데이터) */
    private Output1 output1;

    /** 응답상세2 (단일 데이터) */
    private Output2 output2;

    @Getter
    @ToString
    public static class Output1 {

        /** 주식 현재가 */
        private String stckPrpr;

        /** 전일 대비 */
        private String prdyVrss;

        /** 전일 대비 부호 */
        private String prdyVrssSign;

        /** 전일 대비율 */
        private String prdyCtrt;

        /** 누적 거래량 */
        private String acmlVol;

        /** 전일 거래량 */
        private String prdyVol;

        /** 대표 시장 한글 명 */
        private String rprsMrktKorName;
    }

    @Getter
    @ToString
    public static class Output2 {

        /** 주식 체결 시간 */
        private String stckCntgHour;

        /** 주식 현재가 */
        private String stckPbpr;

        /** 전일 대비 */
        private String prdyVrss;

        /** 전일 대비 부호 */
        private String prdyVrssSign;

        /** 전일 대비율 */
        private String prdyCtrt;

        /** 매도호가 */
        private String askp;

        /** 매수호가 */
        private String bidp;

        /** 당일 체결강도 */
        private String tdayRltv;

        /** 누적 거래량 */
        private String acmlVol;

        /** 체결량 */
        private String cnqn;
    }

}
