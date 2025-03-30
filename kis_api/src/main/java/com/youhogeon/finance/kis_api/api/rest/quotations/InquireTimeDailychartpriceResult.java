package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireTimeDailychartpriceResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 (단일 데이터) */
    private Output1 output1;

    /** 응답상세2 (배열 데이터) */
    private Output2[] output2;

    @Getter
    @ToString
    public static class Output1 {

        /** 전일 대비 */
        private String prdyVrss;

        /** 전일 대비 부호 */
        private String prdyVrssSign;

        /** 전일 대비율 */
        private String prdyCtrt;

        /** 주식 전일 종가 */
        private String stckPrdyClpr;

        /** 누적 거래량 */
        private String acmlVol;

        /** 누적 거래 대금 */
        private String acmlTrPbmn;

        /** HTS 한글 종목명 */
        private String htsKorIsnm;

        /** 주식 현재가 */
        private String stckPrpr;
    }

    @Getter
    @ToString
    public static class Output2 {

        /** 주식 영업 일자 */
        private String stckBsopDate;

        /** 주식 체결 시간 */
        private String stckCntgHour;

        /** 주식 현재가 */
        private String stckPrpr;

        /** 주식 시가2 */
        private String stckOprc;

        /** 주식 최고가 */
        private String stckHgpr;

        /** 주식 최저가 */
        private String stckLwpr;

        /** 체결 거래량 */
        private String cntgVol;

        /** 누적 거래 대금 */
        private String acmlTrPbmn;
    }

}
