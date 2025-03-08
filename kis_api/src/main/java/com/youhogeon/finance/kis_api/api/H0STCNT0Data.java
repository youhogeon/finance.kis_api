package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Getter;

@Getter
public class H0STCNT0Data implements LiveApiData {

    // 유가증권 단축 종목코드
    @Seq(1)
    private String mkscShrnIscd;

    // 주식 체결 시간
    @Seq(2)
    private String stckCntgHour;

    // 주식 현재가
    @Seq(3)
    private int stckPrpr;

    // 전일 대비 부호
    @Seq(4)
    private String prdyVrssSign;

    // 전일 대비
    @Seq(5)
    private int prdyVrss;

    // 전일 대비율
    @Seq(6)
    private double prdyCtrt;

    // 가중 평균 주식 가격
    @Seq(7)
    private double wghnAvrgStckPrc;

    // 주식 시가
    @Seq(8)
    private int stckOprc;

    // 주식 최고가
    @Seq(9)
    private int stckHgpr;

    // 주식 최저가
    @Seq(10)
    private int stckLwpr;

    // 매도호가1
    @Seq(11)
    private int askp1;

    // 매수호가1
    @Seq(12)
    private int bidp1;

    // 체결 거래량
    @Seq(13)
    private long cntgVol;

    // 누적 거래량
    @Seq(14)
    private long acmlVol;

    // 누적 거래 대금
    @Seq(15)
    private long acmlTrPbmn;

    // 매도 체결 건수
    @Seq(16)
    private int selnCntgCsnu;

    // 매수 체결 건수
    @Seq(17)
    private int shnuCntgCsnu;

    // 순매수 체결 건수
    @Seq(18)
    private int ntbyCntgCsnu;

    // 체결강도
    @Seq(19)
    private double cttr;

    // 총 매도 수량
    @Seq(20)
    private long selnCntgSmtn;

    // 총 매수 수량
    @Seq(21)
    private long shnuCntgSmtn;

    // 체결구분
    @Seq(22)
    private String ccldDvsn;

    // 매수비율
    @Seq(23)
    private double shnuRate;

    // 전일 거래량 대비 등락율
    @Seq(24)
    private double prdyVolVrssAcmlVolRate;

    // 시가 시간
    @Seq(25)
    private String oprcHour;

    // 시가대비구분
    @Seq(26)
    private String oprcVrssPrprSign;

    // 시가대비
    @Seq(27)
    private int oprcVrssPrpr;

    // 최고가 시간
    @Seq(28)
    private String hgprHour;

    // 고가대비구분
    @Seq(29)
    private String hgprVrssPrprSign;

    // 고가대비
    @Seq(30)
    private int hgprVrssPrpr;

    // 최저가 시간
    @Seq(31)
    private String lwprHour;

    // 저가대비구분
    @Seq(32)
    private String lwprVrssPrprSign;

    // 저가대비
    @Seq(33)
    private int lwprVrssPrpr;

    // 영업 일자
    @Seq(34)
    private String bsopDate;

    // 신 장운영 구분 코드
    @Seq(35)
    private String newMkopClsCode;

    // 거래정지 여부
    @Seq(36)
    private String trhtYn;

    // 매도호가 잔량1
    @Seq(37)
    private long askpRsqn1;

    // 매수호가 잔량1
    @Seq(38)
    private long bidpRsqn1;

    // 총 매도호가 잔량
    @Seq(39)
    private long totalAskpRsqn;

    // 총 매수호가 잔량
    @Seq(40)
    private long totalBidpRsqn;

    // 거래량 회전율
    @Seq(41)
    private double volTnrt;

    // 전일 동시간 누적 거래량
    @Seq(42)
    private long prdySmnsHourAcmlVol;

    // 전일 동시간 누적 거래량 비율
    @Seq(43)
    private double prdySmnsHourAcmlVolRate;

    // 시간 구분 코드
    @Seq(44)
    private String hourClsCode;

    // 임의종료구분코드
    @Seq(45)
    private String mrktTrtmClsCode;

    // 정적VI발동기준가
    @Seq(46)
    private int viStndPrc;

}
