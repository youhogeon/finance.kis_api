package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class EtfetnInquireComponentStockPriceResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output1 output1;

    /** 응답상세 (배열) */
    private Output2[] output2;

    @Getter
    @ToString
    public static class Output1 {

        /** 매매 일자 */
        private String stckPrpr;

        /** 주식 현재가 */
        private String prdyVrss;

        /** 전일 대비 부호 */
        private String prdyVrssSign;

        /** 전일 대비 */
        private String prdyCtrt;

        /** 전일 대비율 */
        private String etfCnfgIssuAvls;

        /** 누적 거래량 */
        private String nav;

        /** 결제 일자 */
        private String navPrdyVrssSign;

        /** 전체 융자 신규 주수 */
        private String navPrdyVrss;

        /** 전체 융자 상환 주수 */
        private String navPrdyCtrt;

        /** 전체 융자 잔고 주수 */
        private String etfNtasTtam;

        /** 전체 융자 신규 금액 */
        private String prdyClprNav;

        /** 전체 융자 상환 금액 */
        private String oprcNav;

        /** 전체 융자 잔고 금액 */
        private String hprcNav;

        /** 전체 융자 잔고 비율 */
        private String lprcNav;

        /** 전체 융자 공여율 */
        private String etfCuUnitScrtCnt;

        /** 전체 대주 신규 주수 */
        private String etfCnfgIssuCnt;
    }

    @Getter
    @ToString
    public static class Output2 {

        /** 주식 단축 종목코드 */
        private String stckShrnIscd;

        /** HTS 한글 종목명 */
        private String htsKorIsnm;

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

        /** 당일 등락 비율 */
        private String tdayRsflRate;

        /** 전일 대비 거래량 */
        private String prdyVrssVol;

        /** 거래대금회전율 */
        private String trPbmnTnrt;

        /** HTS 시가총액 */
        private String htsAvls;

        /** ETF구성종목시가총액 */
        private String etfCnfgIssuAvls;

        /** ETF구성종목비중 */
        private String etfCnfgIssuRlim;

        /** ETF구성종목내평가금액 */
        private String etfVltnAmt;
    }

}
