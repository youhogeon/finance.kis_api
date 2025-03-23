package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.ToString;

/**
 * 국내지수 실시간프로그램매매 [실시간-028] 실시간 데이터
 */
@Data
@ToString(callSuper = true)
public class H0UPPGM0Data implements RealTimeApiData {

    /** 업종 구분 코드 */
    @Seq(1)
    private String bstpClsCode;

    /** 영업 시간 */
    @Seq(2)
    private String bsopHour;

    /** 차익 매도 위탁 체결량 */
    @Seq(3)
    private String arbtSelnEntmCnqn;

    /** 차익 매도 자기 체결량 */
    @Seq(4)
    private String arbtSelnOnslCnqn;

    /** 차익 매수2 위탁 체결량 */
    @Seq(5)
    private String arbtShnuEntmCnqn;

    /** 차익 매수2 자기 체결량 */
    @Seq(6)
    private String arbtShnuOnslCnqn;

    /** 비차익 매도 위탁 체결량 */
    @Seq(7)
    private String nabtSelnEntmCnqn;

    /** 비차익 매도 자기 체결량 */
    @Seq(8)
    private String nabtSelnOnslCnqn;

    /** 비차익 매수2 위탁 체결량 */
    @Seq(9)
    private String nabtShnuEntmCnqn;

    /** 비차익 매수2 자기 체결량 */
    @Seq(10)
    private String nabtShnuOnslCnqn;

    /** 차익 매도 위탁 체결 금액 */
    @Seq(11)
    private String arbtSelnEntmCntgAmt;

    /** 차익 매도 자기 체결 금액 */
    @Seq(12)
    private String arbtSelnOnslCntgAmt;

    /** 차익 매수2 위탁 체결 금액 */
    @Seq(13)
    private String arbtShnuEntmCntgAmt;

    /** 차익 매수2 자기 체결 금액 */
    @Seq(14)
    private String arbtShnuOnslCntgAmt;

    /** 비차익 매도 위탁 체결 금액 */
    @Seq(15)
    private String nabtSelnEntmCntgAmt;

    /** 비차익 매도 자기 체결 금액 */
    @Seq(16)
    private String nabtSelnOnslCntgAmt;

    /** 비차익 매수2 위탁 체결 금액 */
    @Seq(17)
    private String nabtShnuEntmCntgAmt;

    /** 비차익 매수2 자기 체결 금액 */
    @Seq(18)
    private String nabtShnuOnslCntgAmt;

    /** 차익 합계 매도 거래량 */
    @Seq(19)
    private String arbtSmtnSelnVol;

    /** 차익 합계 매도 거래량 비율 */
    @Seq(20)
    private String arbtSmtmSelnVolRate;

    /** 차익 합계 매도 거래 대금 */
    @Seq(21)
    private String arbtSmtnSelnTrPbmn;

    /** 차익 합계 매도 거래대금 비율 */
    @Seq(22)
    private String arbtSmtmSelnTrPbmnRate;

    /** 차익 합계 매수2 거래량 */
    @Seq(23)
    private String arbtSmtnShnuVol;

    /** 차익 합계 매수 거래량 비율 */
    @Seq(24)
    private String arbtSmtmShnuVolRate;

    /** 차익 합계 매수2 거래 대금 */
    @Seq(25)
    private String arbtSmtnShnuTrPbmn;

    /** 차익 합계 매수 거래대금 비율 */
    @Seq(26)
    private String arbtSmtmShnuTrPbmnRate;

    /** 차익 합계 순매수 수량 */
    @Seq(27)
    private String arbtSmtnNtbyQty;

    /** 차익 합계 순매수 수량 비율 */
    @Seq(28)
    private String arbtSmtmNtbyQtyRate;

    /** 차익 합계 순매수 거래 대금 */
    @Seq(29)
    private String arbtSmtnNtbyTrPbmn;

    /** 차익 합계 순매수 거래대금 비율 */
    @Seq(30)
    private String arbtSmtmNtbyTrPbmnRate;

    /** 비차익 합계 매도 거래량 */
    @Seq(31)
    private String nabtSmtnSelnVol;

    /** 비차익 합계 매도 거래량 비율 */
    @Seq(32)
    private String nabtSmtmSelnVolRate;

    /** 비차익 합계 매도 거래 대금 */
    @Seq(33)
    private String nabtSmtnSelnTrPbmn;

    /** 비차익 합계 매도 거래대금 비율 */
    @Seq(34)
    private String nabtSmtmSelnTrPbmnRate;

    /** 비차익 합계 매수2 거래량 */
    @Seq(35)
    private String nabtSmtnShnuVol;

    /** 비차익 합계 매수 거래량 비율 */
    @Seq(36)
    private String nabtSmtmShnuVolRate;

    /** 비차익 합계 매수2 거래 대금 */
    @Seq(37)
    private String nabtSmtnShnuTrPbmn;

    /** 비차익 합계 매수 거래대금 비율 */
    @Seq(38)
    private String nabtSmtmShnuTrPbmnRate;

    /** 비차익 합계 순매수 수량 */
    @Seq(39)
    private String nabtSmtnNtbyQty;

    /** 비차익 합계 순매수 수량 비율 */
    @Seq(40)
    private String nabtSmtmNtbyQtyRate;

    /** 비차익 합계 순매수 거래 대금 */
    @Seq(41)
    private String nabtSmtnNtbyTrPbmn;

    /** 비차익 합계 순매수 거래대금 비 */
    @Seq(42)
    private String nabtSmtmNtbyTrPbmnRate;

    /** 전체 위탁 매도 거래량 */
    @Seq(43)
    private String wholEntmSelnVol;

    /** 위탁 매도 거래량 비율 */
    @Seq(44)
    private String entmSelnVolRate;

    /** 전체 위탁 매도 거래 대금 */
    @Seq(45)
    private String wholEntmSelnTrPbmn;

    /** 위탁 매도 거래대금 비율 */
    @Seq(46)
    private String entmSelnTrPbmnRate;

    /** 전체 위탁 매수2 거래량 */
    @Seq(47)
    private String wholEntmShnuVol;

    /** 위탁 매수 거래량 비율 */
    @Seq(48)
    private String entmShnuVolRate;

    /** 전체 위탁 매수2 거래 대금 */
    @Seq(49)
    private String wholEntmShnuTrPbmn;

    /** 위탁 매수 거래대금 비율 */
    @Seq(50)
    private String entmShnuTrPbmnRate;

    /** 전체 위탁 순매수 수량 */
    @Seq(51)
    private String wholEntmNtbyQt;

    /** 위탁 순매수 수량 비율 */
    @Seq(52)
    private String entmNtbyQtyRat;

    /** 전체 위탁 순매수 거래 대금 */
    @Seq(53)
    private String wholEntmNtbyTrPbmn;

    /** 위탁 순매수 금액 비율 */
    @Seq(54)
    private String entmNtbyTrPbmnRate;

    /** 전체 자기 매도 거래량 */
    @Seq(55)
    private String wholOnslSelnVol;

    /** 자기 매도 거래량 비율 */
    @Seq(56)
    private String onslSelnVolRate;

    /** 전체 자기 매도 거래 대금 */
    @Seq(57)
    private String wholOnslSelnTrPbmn;

    /** 자기 매도 거래대금 비율 */
    @Seq(58)
    private String onslSelnTrPbmnRate;

    /** 전체 자기 매수2 거래량 */
    @Seq(59)
    private String wholOnslShnuVol;

    /** 자기 매수 거래량 비율 */
    @Seq(60)
    private String onslShnuVolRate;

    /** 전체 자기 매수2 거래 대금 */
    @Seq(61)
    private String wholOnslShnuTrPbmn;

    /** 자기 매수 거래대금 비율 */
    @Seq(62)
    private String onslShnuTrPbmnRate;

    /** 전체 자기 순매수 수량 */
    @Seq(63)
    private String wholOnslNtbyQty;

    /** 자기 순매수량 비율 */
    @Seq(64)
    private String onslNtbyQtyRate;

    /** 전체 자기 순매수 거래 대금 */
    @Seq(65)
    private String wholOnslNtbyTrPbmn;

    /** 자기 순매수 대금 비율 */
    @Seq(66)
    private String onslNtbyTrPbmnRate;

    /** 총 매도 수량 */
    @Seq(67)
    private String totalSelnQty;

    /** 전체 매도 거래량 비율 */
    @Seq(68)
    private String wholSelnVolRate;

    /** 총 매도 거래 대금 */
    @Seq(69)
    private String totalSelnTrPbmn;

    /** 전체 매도 거래대금 비율 */
    @Seq(70)
    private String wholSelnTrPbmnRate;

    /** 총 매수 수량 */
    @Seq(71)
    private String shnuCntgSmtn;

    /** 전체 매수 거래량 비율 */
    @Seq(72)
    private String wholShunVolRate;

    /** 총 매수2 거래 대금 */
    @Seq(73)
    private String totalShnuTrPbmn;

    /** 전체 매수 거래대금 비율 */
    @Seq(74)
    private String wholShunTrPbmnRate;

    /** 전체 순매수 수량 */
    @Seq(75)
    private String wholNtbyQty;

    /** 전체 합계 순매수 수량 비율 */
    @Seq(76)
    private String wholSmtmNtbyQtyRate;

    /** 전체 순매수 거래 대금 */
    @Seq(77)
    private String wholNtbyTrPbmn;

    /** 전체 순매수 거래대금 비율 */
    @Seq(78)
    private String wholNtbyTrPbmnRate;

    /** 차익 위탁 순매수 수량 */
    @Seq(79)
    private String arbtEntmNtbyQty;

    /** 차익 위탁 순매수 거래 대금 */
    @Seq(80)
    private String arbtEntmNtbyTrPbmn;

    /** 차익 자기 순매수 수량 */
    @Seq(81)
    private String arbtOnslNtbyQty;

    /** 차익 자기 순매수 거래 대금 */
    @Seq(82)
    private String arbtOnslNtbyTrPbmn;

    /** 비차익 위탁 순매수 수량 */
    @Seq(83)
    private String nabtEntmNtbyQty;

    /** 비차익 위탁 순매수 거래 대금 */
    @Seq(84)
    private String nabtEntmNtbyTrPbmn;

    /** 비차익 자기 순매수 수량 */
    @Seq(85)
    private String nabtOnslNtbyQty;

    /** 비차익 자기 순매수 거래 대금 */
    @Seq(86)
    private String nabtOnslNtbyTrPbmn;

    /** 누적 거래량 */
    @Seq(87)
    private String acmlVol;

    /** 누적 거래 대금 */
    @Seq(88)
    private String acmlTrPbmn;

}
