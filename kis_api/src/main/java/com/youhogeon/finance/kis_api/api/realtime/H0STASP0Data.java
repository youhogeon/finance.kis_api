package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.ToString;

/**
 * 국내주식 실시간호가 (KRX) [실시간-004] 실시간 데이터
 */
@Data
@ToString(callSuper = true)
public class H0STASP0Data implements RealTimeApiData {

    /** 유가증권 단축 종목코드 */
    @Seq(1)
    private String mkscShrnIscd;

    /** 영업 시간 */
    @Seq(2)
    private String bsopHour;

    /** 시간 구분 코드 */
    @Seq(3)
    private String hourClsCode;

    /** 매도호가1 */
    @Seq(4)
    private Number askp1;

    /** 매도호가2 */
    @Seq(5)
    private Number askp2;

    /** 매도호가3 */
    @Seq(6)
    private Number askp3;

    /** 매도호가4 */
    @Seq(7)
    private Number askp4;

    /** 매도호가5 */
    @Seq(8)
    private Number askp5;

    /** 매도호가6 */
    @Seq(9)
    private Number askp6;

    /** 매도호가7 */
    @Seq(10)
    private Number askp7;

    /** 매도호가8 */
    @Seq(11)
    private Number askp8;

    /** 매도호가9 */
    @Seq(12)
    private Number askp9;

    /** 매도호가10 */
    @Seq(13)
    private Number askp10;

    /** 매수호가1 */
    @Seq(14)
    private Number bidp1;

    /** 매수호가2 */
    @Seq(15)
    private Number bidp2;

    /** 매수호가3 */
    @Seq(16)
    private Number bidp3;

    /** 매수호가4 */
    @Seq(17)
    private Number bidp4;

    /** 매수호가5 */
    @Seq(18)
    private Number bidp5;

    /** 매수호가6 */
    @Seq(19)
    private Number bidp6;

    /** 매수호가7 */
    @Seq(20)
    private Number bidp7;

    /** 매수호가8 */
    @Seq(21)
    private Number bidp8;

    /** 매수호가9 */
    @Seq(22)
    private Number bidp9;

    /** 매수호가10 */
    @Seq(23)
    private Number bidp10;

    /** 매도호가 잔량1 */
    @Seq(24)
    private Number askpRsqn1;

    /** 매도호가 잔량2 */
    @Seq(25)
    private Number askpRsqn2;

    /** 매도호가 잔량3 */
    @Seq(26)
    private Number askpRsqn3;

    /** 매도호가 잔량4 */
    @Seq(27)
    private Number askpRsqn4;

    /** 매도호가 잔량5 */
    @Seq(28)
    private Number askpRsqn5;

    /** 매도호가 잔량6 */
    @Seq(29)
    private Number askpRsqn6;

    /** 매도호가 잔량7 */
    @Seq(30)
    private Number askpRsqn7;

    /** 매도호가 잔량8 */
    @Seq(31)
    private Number askpRsqn8;

    /** 매도호가 잔량9 */
    @Seq(32)
    private Number askpRsqn9;

    /** 매도호가 잔량10 */
    @Seq(33)
    private Number askpRsqn10;

    /** 매수호가 잔량1 */
    @Seq(34)
    private Number bidpRsqn1;

    /** 매수호가 잔량2 */
    @Seq(35)
    private Number bidpRsqn2;

    /** 매수호가 잔량3 */
    @Seq(36)
    private Number bidpRsqn3;

    /** 매수호가 잔량4 */
    @Seq(37)
    private Number bidpRsqn4;

    /** 매수호가 잔량5 */
    @Seq(38)
    private Number bidpRsqn5;

    /** 매수호가 잔량6 */
    @Seq(39)
    private Number bidpRsqn6;

    /** 매수호가 잔량7 */
    @Seq(40)
    private Number bidpRsqn7;

    /** 매수호가 잔량8 */
    @Seq(41)
    private Number bidpRsqn8;

    /** 매수호가 잔량9 */
    @Seq(42)
    private Number bidpRsqn9;

    /** 매수호가 잔량10 */
    @Seq(43)
    private Number bidpRsqn10;

    /** 총 매도호가 잔량 */
    @Seq(44)
    private Number totalAskpRsqn;

    /** 총 매수호가 잔량 */
    @Seq(45)
    private Number totalBidpRsqn;

    /** 시간외 총 매도호가 잔량 */
    @Seq(46)
    private Number ovtmTotalAskpRsqn;

    /** 시간외 총 매수호가 잔량 */
    @Seq(47)
    private Number ovtmTotalBidpRsqn;

    /** 예상 체결가 */
    @Seq(48)
    private Number antcCnpr;

    /** 예상 체결량 */
    @Seq(49)
    private Number antcCnqn;

    /** 예상 거래량 */
    @Seq(50)
    private Number antcVol;

    /** 예상 체결 대비 */
    @Seq(51)
    private Number antcCntgVrss;

    /** 예상 체결 대비 부호 */
    @Seq(52)
    private String antcCntgVrssSign;

    /** 예상 체결 전일 대비율 */
    @Seq(53)
    private Number antcCntgPrdyCtrt;

    /** 누적 거래량 */
    @Seq(54)
    private Number acmlVol;

    /** 총 매도호가 잔량 증감 */
    @Seq(55)
    private Number totalAskpRsqnIcdc;

    /** 총 매수호가 잔량 증감 */
    @Seq(56)
    private Number totalBidpRsqnIcdc;

    /** 시간외 총 매도호가 증감 */
    @Seq(57)
    private Number ovtmTotalAskpIcdc;

    /** 시간외 총 매수호가 증감 */
    @Seq(58)
    private Number ovtmTotalBidpIcdc;

    /** 주식 매매 구분 코드 */
    @Seq(59)
    private String stckDealClsCode;

}
