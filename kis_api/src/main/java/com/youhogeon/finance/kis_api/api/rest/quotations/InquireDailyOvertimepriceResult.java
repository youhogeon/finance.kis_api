package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireDailyOvertimepriceResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세1 (기본정보) */
    private Output1 output1;

    /** 응답상세2 (일자별 정보) */
    private Output2[] output2;

    @Getter
    @ToString
    public static class Output1 {

        /** 시간외 단일가 현재가 */
        private String ovtmUntpPrpr;

        /** 시간외 단일가 전일 대비 */
        private String ovtmUntpPrdyVrss;

        /** 시간외 단일가 전일 대비 부호 */
        private String ovtmUntpPrdyVrssSign;

        /** 시간외 단일가 전일 대비율 */
        private String ovtmUntpPrdyCtrt;

        /** 시간외 단일가 거래량 */
        private String ovtmUntpVol;

        /** 시간외 단일가 거래 대금 */
        private String ovtmUntpTrPbmn;

        /** 시간외 단일가 상한가 */
        private String ovtmUntpMxpr;

        /** 시간외 단일가 하한가 */
        private String ovtmUntpLlam;

        /** 시간외 단일가 시가2 */
        private String ovtmUntpOprc;

        /** 시간외 단일가 최고가 */
        private String ovtmUntpHgpr;

        /** 시간외 단일가 최저가 */
        private String ovtmUntpLwpr;

        /** 시간외 단일가 예상 체결가 */
        private String ovtmUntpAntcCnpr;

        /** 시간외 단일가 예상 체결 대비 */
        private String ovtmUntpAntcCntgVrss;

        /** 시간외 단일가 예상 체결 대비 부호 */
        private String ovtmUntpAntcCntgVrssSign;

        /** 시간외 단일가 예상 체결 대비율 */
        private String ovtmUntpAntcCntgCtrt;

        /** 시간외 단일가 예상 거래량 */
        private String ovtmUntpAntcVol;
    }

    @Getter
    @ToString
    public static class Output2 {

        /** 주식 영업 일자 */
        private String stckBsopDate;

        /** 시간외 단일가 현재가 */
        private String ovtmUntpPrpr;

        /** 시간외 단일가 전일 대비 */
        private String ovtmUntpPrdyVrss;

        /** 시간외 단일가 전일 대비 부호 */
        private String ovtmUntpPrdyVrssSign;

        /** 시간외 단일가 전일 대비율 */
        private String ovtmUntpPrdyCtrt;

        /** 시간외 단일가 거래량 */
        private String ovtmUntpVol;

        /** 주식 종가 */
        private String stckClpr;

        /** 전일 대비 */
        private String prdyVrss;

        /** 전일 대비 부호 */
        private String prdyVrssSign;

        /** 전일 대비율 */
        private String prdyCtrt;

        /** 누적 거래량 */
        private String acmlVol;

        /** 시간외 단일가 거래대금 */
        private String ovtmUntpTrPbmn;
    }


}
