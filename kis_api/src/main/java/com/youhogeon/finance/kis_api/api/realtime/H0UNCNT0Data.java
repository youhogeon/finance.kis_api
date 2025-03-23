package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.ToString;

/**
 * 국내주식 실시간체결가 (통합) 실시간 데이터
 */
@Data
@ToString(callSuper = true)
public class H0UNCNT0Data implements RealTimeApiData {

    /** 유가증권 단축 종목코드 */
    @Seq(1)
    private String mkscShrnIscd;

    /** 주식 체결 시간 */
    @Seq(2)
    private String stckCntgHour;

    /** 주식 현재가 */
    @Seq(3)
    private String stckPrpr;

    /** 전일 대비 부호 */
    @Seq(4)
    private String prdyVrssSign;

    /** 전일 대비 */
    @Seq(5)
    private String prdyVrss;

    /** 전일 대비율 */
    @Seq(6)
    private String prdyCtrt;

    /** 가중 평균 주식 가격 */
    @Seq(7)
    private String wghnAvrgStckPrc;

    /** 주식 시가 */
    @Seq(8)
    private String stckOprc;

    /** 주식 최고가 */
    @Seq(9)
    private String stckHgpr;

    /** 주식 최저가 */
    @Seq(10)
    private String stckLwpr;

    /** 매도호가1 */
    @Seq(11)
    private String askp1;

    /** 매수호가1 */
    @Seq(12)
    private String bidp1;

    /** 체결 거래량 */
    @Seq(13)
    private String cntgVol;

    /** 누적 거래량 */
    @Seq(14)
    private String acmlVol;

    /** 누적 거래 대금 */
    @Seq(15)
    private String acmlTrPbmn;

    /** 매도 체결 건수 */
    @Seq(16)
    private String selnCntgCsnu;

    /** 매수 체결 건수 */
    @Seq(17)
    private String shnuCntgCsnu;

    /** 순매수 체결 건수 */
    @Seq(18)
    private String ntbyCntgCsnu;

    /** 체결강도 */
    @Seq(19)
    private String cttr;

    /** 총 매도 수량 */
    @Seq(20)
    private String selnCntgSmtn;

    /** 총 매수 수량 */
    @Seq(21)
    private String shnuCntgSmtn;

    /** 체결구분 */
    @Seq(22)
    private String cntgClsCode;

    /** 매수비율 */
    @Seq(23)
    private String shnuRate;

    /** 전일 거래량 대비 등락율 */
    @Seq(24)
    private String prdyVolVrssAcmlVolRate;

    /** 시가 시간 */
    @Seq(25)
    private String oprcHour;

    /** 시가대비구분 */
    @Seq(26)
    private String oprcVrssPrprSign;

    /** 시가대비 */
    @Seq(27)
    private String oprcVrssPrpr;

    /** 최고가 시간 */
    @Seq(28)
    private String hgprHour;

    /** 고가대비구분 */
    @Seq(29)
    private String hgprVrssPrprSign;

    /** 고가대비 */
    @Seq(30)
    private String hgprVrssPrpr;

    /** 최저가 시간 */
    @Seq(31)
    private String lwprHour;

    /** 저가대비구분 */
    @Seq(32)
    private String lwprVrssPrprSign;

    /** 저가대비 */
    @Seq(33)
    private String lwprVrssPrpr;

    /** 영업 일자 */
    @Seq(34)
    private String bsopDate;

    /** 신 장운영 구분 코드 */
    @Seq(35)
    private String newMkopClsCode;

    /** 거래정지 여부 */
    @Seq(36)
    private String trhtYn;

    /** 매도호가 잔량1 */
    @Seq(37)
    private String askpRsqn1;

    /** 매수호가 잔량1 */
    @Seq(38)
    private String bidpRsqn1;

    /** 총 매도호가 잔량 */
    @Seq(39)
    private String totalAskpRsqn;

    /** 총 매수호가 잔량 */
    @Seq(40)
    private String totalBidpRsqn;

    /** 거래량 회전율 */
    @Seq(41)
    private String volTnrt;

    /** 전일 동시간 누적 거래량 */
    @Seq(42)
    private String prdySmnsHourAcmlVol;

    /** 전일 동시간 누적 거래량 비율 */
    @Seq(43)
    private String prdySmnsHourAcmlVolRate;

    /** 시간 구분 코드 */
    @Seq(44)
    private String hourClsCode;

    /** 임의종료구분코드 */
    @Seq(45)
    private String mrktTrtmClsCode;

    /** 정적VI발동기준가 */
    @Seq(46)
    private String viStndPrc;

}
