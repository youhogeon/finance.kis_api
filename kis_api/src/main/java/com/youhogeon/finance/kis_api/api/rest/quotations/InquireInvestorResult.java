package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireInvestorResult extends CommonRestResult {

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

        /** 주식 종가 */
        private String stckClpr;

        /** 전일 대비 */
        private String prdyVrss;

        /** 전일 대비 부호 */
        private String prdyVrssSign;

        /** 개인 순매수 수량 */
        private String prsnNtbyQty;

        /** 외국인 순매수 수량 */
        private String frgnNtbyQty;

        /** 기관계 순매수 수량 */
        private String orgnNtbyQty;

        /** 개인 순매수 거래 대금 */
        private String prsnNtbyTrPbmn;

        /** 외국인 순매수 거래 대금 */
        private String frgnNtbyTrPbmn;

        /** 기관계 순매수 거래 대금 */
        private String orgnNtbyTrPbmn;

        /** 개인 매수2 거래량 */
        private String prsnShnuVol;

        /** 외국인 매수2 거래량 */
        private String frgnShnuVol;

        /** 기관계 매수2 거래량 */
        private String orgnShnuVol;

        /** 개인 매수2 거래 대금 */
        private String prsnShnuTrPbmn;

        /** 외국인 매수2 거래 대금 */
        private String frgnShnuTrPbmn;

        /** 기관계 매수2 거래 대금 */
        private String orgnShnuTrPbmn;

        /** 개인 매도 거래량 */
        private String prsnSelnVol;

        /** 외국인 매도 거래량 */
        private String frgnSelnVol;

        /** 기관계 매도 거래량 */
        private String orgnSelnVol;

        /** 개인 매도 거래 대금 */
        private String prsnSelnTrPbmn;

        /** 외국인 매도 거래 대금 */
        private String frgnSelnTrPbmn;

        /** 기관계 매도 거래 대금 */
        private String orgnSelnTrPbmn;
    }

}
