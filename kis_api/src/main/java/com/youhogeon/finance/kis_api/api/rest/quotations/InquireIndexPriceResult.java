package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireIndexPriceResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세1 */
    private Output output;

    @Getter
    @ToString
    public static class Output {

        /** 업종 지수 현재가 */
        private String bstpNmixPrpr;

        /** 업종 지수 전일 대비 */
        private String bstpNmixPrdyVrss;

        /** 전일 대비 부호 */
        private String prdyVrssSign;

        /** 업종 지수 전일 대비율 */
        private String bstpNmixPrdyCtrt;

        /** 누적 거래량 */
        private String acmlVol;

        /** 전일 거래량 */
        private String prdyVol;

        /** 누적 거래 대금 */
        private String acmlTrPbmn;

        /** 전일 거래 대금 */
        private String prdyTrPbmn;

        /** 업종 지수 시가2 */
        private String bstpNmixOprc;

        /** 전일 지수 대비 지수 시가2 */
        private String prdyNmixVrssNmixOprc;

        /** 시가2 대비 현재가 부호 */
        private String oprcVrssPrprSign;

        /** 업종 지수 시가2 전일 대비율 */
        private String bstpNmixOprcPrdyCtrt;

        /** 업종 지수 최고가 */
        private String bstpNmixHgpr;

        /** 전일 지수 대비 지수 최고가 */
        private String prdyNmixVrssNmixHgpr;

        /** 최고가 대비 현재가 부호 */
        private String hgprVrssPrprSign;

        /** 업종 지수 최고가 전일 대비율 */
        private String bstpNmixHgprPrdyCtrt;

        /** 업종 지수 최저가 */
        private String bstpNmixLwpr;

        /** 전일 종가 대비 최저가 */
        private String prdyClprVrssLwpr;

        /** 최저가 대비 현재가 부호 */
        private String lwprVrssPrprSign;

        /** 전일 종가 대비 최저가 비율 */
        private String prdyClprVrssLwprRate;

        /** 상승 종목 수 */
        private String ascnIssuCnt;

        /** 상한 종목 수 */
        private String uplmIssuCnt;

        /** 보합 종목 수 */
        private String stnrIssuCnt;

        /** 하락 종목 수 */
        private String downIssuCnt;

        /** 하한 종목 수 */
        private String lslmIssuCnt;

        /** 연중 업종지수 최고가 */
        private String dryyBstpNmixHgpr;

        /** 연중 최고가 대비 현재가 비율 */
        private String dryyHgprVrssPrprRate;

        /** 연중 업종지수 최고가 일자 */
        private String dryyBstpNmixHgprDate;

        /** 연중 업종지수 최저가 */
        private String dryyBstpNmixLwpr;

        /** 연중 최저가 대비 현재가 비율 */
        private String dryyLwprVrssPrprRate;

        /** 연중 업종지수 최저가 일자 */
        private String dryyBstpNmixLwprDate;

        /** 총 매도호가 잔량 */
        private String totalAskpRsqn;

        /** 총 매수호가 잔량 */
        private String totalBidpRsqn;

        /** 매도 잔량 비율 */
        private String selnRsqnRate;

        /** 매수2 잔량 비율 */
        private String shnuRsqnRate;

        /** 순매수 잔량 */
        private String ntbyRsqn;
    }

}
