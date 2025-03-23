package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.ToString;

/**
 * 국내주식 실시간회원사 (KRX) [실시간-047] 실시간 데이터
 */
@Data
@ToString(callSuper = true)
public class H0STMBC0Data implements RealTimeApiData {

    /** 유가증권단축종목코드 */
    @Seq(1)
    private String mkscShrnIscd;

    /** 매도2회원사명1 */
    @Seq(2)
    private String seln2MbcrName1;

    /** 매도2회원사명2 */
    @Seq(3)
    private String seln2MbcrName2;

    /** 매도2회원사명3 */
    @Seq(4)
    private String seln2MbcrName3;

    /** 매도2회원사명4 */
    @Seq(5)
    private String seln2MbcrName4;

    /** 매도2회원사명5 */
    @Seq(6)
    private String seln2MbcrName5;

    /** 매수회원사명1 */
    @Seq(7)
    private String byovMbcrName1;

    /** 매수회원사명2 */
    @Seq(8)
    private String byovMbcrName2;

    /** 매수회원사명3 */
    @Seq(9)
    private String byovMbcrName3;

    /** 매수회원사명4 */
    @Seq(10)
    private String byovMbcrName4;

    /** 매수회원사명5 */
    @Seq(11)
    private String byovMbcrName5;

    /** 총매도수량1 */
    @Seq(12)
    private String totalSelnQty1;

    /** 총매도수량2 */
    @Seq(13)
    private String totalSelnQty2;

    /** 총매도수량3 */
    @Seq(14)
    private String totalSelnQty3;

    /** 총매도수량4 */
    @Seq(15)
    private String totalSelnQty4;

    /** 총매도수량5 */
    @Seq(16)
    private String totalSelnQty5;

    /** 총매수2수량1 */
    @Seq(17)
    private String totalShnuQty1;

    /** 총매수2수량2 */
    @Seq(18)
    private String totalShnuQty2;

    /** 총매수2수량3 */
    @Seq(19)
    private String totalShnuQty3;

    /** 총매수2수량4 */
    @Seq(20)
    private String totalShnuQty4;

    /** 총매수2수량5 */
    @Seq(21)
    private String totalShnuQty5;

    /** 매도거래원구분1 */
    @Seq(22)
    private String selnMbcrGlobYn1;

    /** 매도거래원구분2 */
    @Seq(23)
    private String selnMbcrGlobYn2;

    /** 매도거래원구분3 */
    @Seq(24)
    private String selnMbcrGlobYn3;

    /** 매도거래원구분4 */
    @Seq(25)
    private String selnMbcrGlobYn4;

    /** 매도거래원구분5 */
    @Seq(26)
    private String selnMbcrGlobYn5;

    /** 매수거래원구분1 */
    @Seq(27)
    private String shnuMbcrGlobYn1;

    /** 매수거래원구분2 */
    @Seq(28)
    private String shnuMbcrGlobYn2;

    /** 매수거래원구분3 */
    @Seq(29)
    private String shnuMbcrGlobYn3;

    /** 매수거래원구분4 */
    @Seq(30)
    private String shnuMbcrGlobYn4;

    /** 매수거래원구분5 */
    @Seq(31)
    private String shnuMbcrGlobYn5;

    /** 매도거래원코드1 */
    @Seq(32)
    private String selnMbcrNo1;

    /** 매도거래원코드2 */
    @Seq(33)
    private String selnMbcrNo2;

    /** 매도거래원코드3 */
    @Seq(34)
    private String selnMbcrNo3;

    /** 매도거래원코드4 */
    @Seq(35)
    private String selnMbcrNo4;

    /** 매도거래원코드5 */
    @Seq(36)
    private String selnMbcrNo5;

    /** 매수거래원코드1 */
    @Seq(37)
    private String shnuMbcrNo1;

    /** 매수거래원코드2 */
    @Seq(38)
    private String shnuMbcrNo2;

    /** 매수거래원코드3 */
    @Seq(39)
    private String shnuMbcrNo3;

    /** 매수거래원코드4 */
    @Seq(40)
    private String shnuMbcrNo4;

    /** 매수거래원코드5 */
    @Seq(41)
    private String shnuMbcrNo5;

    /** 매도회원사비중1 */
    @Seq(42)
    private String selnMbcrRlim1;

    /** 매도회원사비중2 */
    @Seq(43)
    private String selnMbcrRlim2;

    /** 매도회원사비중3 */
    @Seq(44)
    private String selnMbcrRlim3;

    /** 매도회원사비중4 */
    @Seq(45)
    private String selnMbcrRlim4;

    /** 매도회원사비중5 */
    @Seq(46)
    private String selnMbcrRlim5;

    /** 매수2회원사비중1 */
    @Seq(47)
    private String shnuMbcrRlim1;

    /** 매수2회원사비중2 */
    @Seq(48)
    private String shnuMbcrRlim2;

    /** 매수2회원사비중3 */
    @Seq(49)
    private String shnuMbcrRlim3;

    /** 매수2회원사비중4 */
    @Seq(50)
    private String shnuMbcrRlim4;

    /** 매수2회원사비중5 */
    @Seq(51)
    private String shnuMbcrRlim5;

    /** 매도수량증감1 */
    @Seq(52)
    private String selnQtyIcdc1;

    /** 매도수량증감2 */
    @Seq(53)
    private String selnQtyIcdc2;

    /** 매도수량증감3 */
    @Seq(54)
    private String selnQtyIcdc3;

    /** 매도수량증감4 */
    @Seq(55)
    private String selnQtyIcdc4;

    /** 매도수량증감5 */
    @Seq(56)
    private String selnQtyIcdc5;

    /** 매수2수량증감1 */
    @Seq(57)
    private String shnuQtyIcdc1;

    /** 매수2수량증감2 */
    @Seq(58)
    private String shnuQtyIcdc2;

    /** 매수2수량증감3 */
    @Seq(59)
    private String shnuQtyIcdc3;

    /** 매수2수량증감4 */
    @Seq(60)
    private String shnuQtyIcdc4;

    /** 매수2수량증감5 */
    @Seq(61)
    private String shnuQtyIcdc5;

    /** 외국계총매도수량 */
    @Seq(62)
    private String globTotalSelnQty;

    /** 외국계총매수2수량 */
    @Seq(63)
    private String globTotalShnuQty;

    /** 외국계총매도수량증감 */
    @Seq(64)
    private String globTotalSelnQtyIcdc;

    /** 외국계총매수2수량증감 */
    @Seq(65)
    private String globTotalShnuQtyIcdc;

    /** 외국계순매수수량 */
    @Seq(66)
    private String globNtbyQty;

    /** 외국계매도비중 */
    @Seq(67)
    private String globSelnRlim;

    /** 외국계매수2비중 */
    @Seq(68)
    private String globShnuRlim;

    /** 매도2영문회원사명1 */
    @Seq(69)
    private String seln2MbcrEngName1;

    /** 매도2영문회원사명2 */
    @Seq(70)
    private String seln2MbcrEngName2;

    /** 매도2영문회원사명3 */
    @Seq(71)
    private String seln2MbcrEngName3;

    /** 매도2영문회원사명4 */
    @Seq(72)
    private String seln2MbcrEngName4;

    /** 매도2영문회원사명5 */
    @Seq(73)
    private String seln2MbcrEngName5;

    /** 매수영문회원사명1 */
    @Seq(74)
    private String byovMbcrEngName1;

    /** 매수영문회원사명2 */
    @Seq(75)
    private String byovMbcrEngName2;

    /** 매수영문회원사명3 */
    @Seq(76)
    private String byovMbcrEngName3;

    /** 매수영문회원사명4 */
    @Seq(77)
    private String byovMbcrEngName4;

    /** 매수영문회원사명5 */
    @Seq(78)
    private String byovMbcrEngName5;

}
