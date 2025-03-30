package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class EtfetnNavComparisonTrendResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output1 output1;

    /** 응답상세2 */
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

        /** 누적 거래 대금 */
        private String acmlTrPbmn;

        /** 주식 전일 종가 */
        private String stckPrdyClpr;

        /** 주식 시가2 */
        private String stckOprc;

        /** 주식 최고가 */
        private String stckHgpr;

        /** 주식 최저가 */
        private String stckLwpr;

        /** 주식 상한가 */
        private String stckMxpr;

        /** 주식 하한가 */
        private String stckLlam;
    }

    @Getter
    @ToString
    public static class Output2 {

        /** NAV */
        private String nav;

        /** NAV 전일 대비 부호 */
        private String navPrdyVrssSign;

        /** NAV 전일 대비 */
        private String navPrdyVrss;

        /** NAV 전일 대비율 */
        private String navPrdyCtrt;

        /** NAV전일종가 */
        private String prdyClprNav;

        /** NAV시가 */
        private String oprcNav;

        /** NAV고가 */
        private String hprcNav;

        /** NAV저가 */
        private String lprcNav;
    }

}
