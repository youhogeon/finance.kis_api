package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.ToString;

/**
 * 국내지수 실시간예상체결 [실시간-027] 실시간 데이터
 */
@Data
@ToString(callSuper = true)
public class H0UPANC0Data implements RealTimeApiData {

    /** 업종 구분 코드 */
    @Seq(1)
    private String bstpClsCode;

    /** 영업 시간 */
    @Seq(2)
    private String bsopHour;

    /** 현재가 지수 */
    @Seq(3)
    private String prprNmix;

    /** 전일 대비 부호 */
    @Seq(4)
    private String prdyVrssSign;

    /** 업종 지수 전일 대비 */
    @Seq(5)
    private String bstpNmixPrdyVrss;

    /** 누적 거래량 */
    @Seq(6)
    private String acmlVol;

    /** 누적 거래 대금 */
    @Seq(7)
    private String acmlTrPbmn;

    /** 건별 거래량 */
    @Seq(8)
    private String pcasVol;

    /** 건별 거래 대금 */
    @Seq(9)
    private String pcasTrPbmn;

    /** 전일 대비율 */
    @Seq(10)
    private String prdyCtrt;

    /** 시가 지수 */
    @Seq(11)
    private String oprcNmix;

    /** 지수 최고가 */
    @Seq(12)
    private String nmixHgpr;

    /** 지수 최저가 */
    @Seq(13)
    private String nmixLwpr;

    /** 시가 대비 지수 현재가 */
    @Seq(14)
    private String oprcVrssNmixPrpr;

    /** 시가 대비 지수 부호 */
    @Seq(15)
    private String oprcVrssNmixSign;

    /** 최고가 대비 지수 현재가 */
    @Seq(16)
    private String hgprVrssNmixPrpr;

    /** 최고가 대비 지수 부호 */
    @Seq(17)
    private String hgprVrssNmixSign;

    /** 최저가 대비 지수 현재가 */
    @Seq(18)
    private String lwprVrssNmixPrpr;

    /** 최저가 대비 지수 부호 */
    @Seq(19)
    private String lwprVrssNmixSign;

    /** 전일 종가 대비 시가2 비율 */
    @Seq(20)
    private String prdyClprVrssOprcRate;

    /** 전일 종가 대비 최고가 비율 */
    @Seq(21)
    private String prdyClprVrssHgprRate;

    /** 전일 종가 대비 최저가 비율 */
    @Seq(22)
    private String prdyClprVrssLwprRate;

    /** 상한 종목 수 */
    @Seq(23)
    private String uplmIssuCnt;

    /** 상승 종목 수 */
    @Seq(24)
    private String ascnIssuCnt;

    /** 보합 종목 수 */
    @Seq(25)
    private String stnrIssuCnt;

    /** 하락 종목 수 */
    @Seq(26)
    private String downIssuCnt;

    /** 하한 종목 수 */
    @Seq(27)
    private String lslmIssuCnt;

    /** 기세 상승 종목수 */
    @Seq(28)
    private String qtqtAscnIssuCnt;

    /** 기세 하락 종목수 */
    @Seq(29)
    private String qtqtDownIssuCnt;

    /** TICK대비 */
    @Seq(30)
    private String tickVrss;

}
