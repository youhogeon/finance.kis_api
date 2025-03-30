package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireDailyPriceResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 (배열) */
    private Output1[] output1;

    @Getter
    @ToString
    public static class Output1 {

        /** 주식 영업 일자 */
        private String stckBsopDate;

        /** 주식 시가2 */
        private String stckOprc;

        /** 주식 최고가 */
        private String stckHgpr;

        /** 주식 최저가 */
        private String stckLwpr;

        /** 주식 종가 */
        private String stckClpr;

        /** 누적 거래량 */
        private String acmlVol;

        /** 전일 대비 거래량 비율 */
        private String prdyVrssVolRate;

        /** 전일 대비 */
        private String prdyVrss;

        /** 전일 대비 부호 */
        private String prdyVrssSign;

        /** 전일 대비율 */
        private String prdyCtrt;

        /** HTS 외국인 소진율 */
        private String htsFrgnEhrt;

        /** 외국인 순매수 수량 */
        private String frgnNtbyQty;

        /**
         * 락 구분 코드
         * 01: 권리락, 02: 배당락, 03: 분배락, 04: 권배락,
         * 05: 중간(분기)배당락, 06: 권리중간배당락, 07: 권리분기배당락
         */
        private String flngClsCode;

        /** 누적 분할 비율 */
        private String acmlPrttRate;
    }

}
