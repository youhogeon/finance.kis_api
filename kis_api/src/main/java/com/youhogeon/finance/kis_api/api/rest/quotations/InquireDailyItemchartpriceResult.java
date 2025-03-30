package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireDailyItemchartpriceResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세1 */
    private Output1 output1;

    /** 응답상세2 */
    private Output2 output2;

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

        /** 주식 단축 종목코드 */
        private String stckShrnIscd;

        /** 전일 거래량 */
        private String prdyVol;

        /** 주식 상한가 */
        private String stckMxpr;

        /** 주식 하한가 */
        private String stckLlam;

        /** 주식 시가2 */
        private String stckOprc;

        /** 주식 최고가 */
        private String stckHgpr;

        /** 주식 최저가 */
        private String stckLwpr;

        /** 주식 전일 시가 */
        private String stckPrdyOprc;

        /** 주식 전일 최고가 */
        private String stckPrdyHgpr;

        /** 주식 전일 최저가 */
        private String stckPrdyLwpr;

        /** 매도호가 */
        private String askp;

        /** 매수호가 */
        private String bidp;

        /** 전일 대비 거래량 */
        private String prdyVrssVol;

        /** 거래량 회전율 */
        private String volTnrt;

        /** 주식 액면가 */
        private String stckFcam;

        /** 상장 주수 */
        private String lstnStcn;

        /** 자본금 */
        private String cpfn;

        /** HTS 시가총액 */
        private String htsAvls;

        /** PER */
        private String per;

        /** EPS */
        private String eps;

        /** PBR */
        private String pbr;

        /** 전체 융자 잔고 비율 */
        private String itewholLoanRmndRatem;
    }

    @Getter
    @ToString
    public static class Output2 {

        /** 전일 대비 */
        private String stckBsopDate;

        /** 전일 대비 부호 */
        private String stckClpr;

        /** 전일 대비율 */
        private String stckOprc;

        /** 주식 전일 종가 */
        private String stckHgpr;

        /** 누적 거래량 */
        private String stckLwpr;

        /** 누적 거래 대금 */
        private String acmlVol;

        /** HTS 한글 종목명 */
        private String acmlTrPbmn;

        /** 주식 현재가 */
        private String flngClsCode;

        /** 주식 단축 종목코드 */
        private String prttRate;

        /** 전일 거래량 */
        private String modYn;

        /** 주식 상한가 */
        private String prdyVrssSign;

        /** 주식 하한가 */
        private String prdyVrss;

        /** 주식 시가2 */
        private String revlIssuReas;
    }

}
