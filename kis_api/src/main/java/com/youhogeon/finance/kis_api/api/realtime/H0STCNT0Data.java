package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class H0STCNT0Data implements RealTimeApiData {

    // 유가증권 단축 종목코드
    @Seq(1)
    public String mkscShrnIscd;

    // 주식 체결 시간
    @Seq(2)
    public String stckCntgHour;

    // 주식 현재가
    @Seq(3)
    public int stckPrpr;

    // 전일 대비 부호
    @Seq(4)
    public String prdyVrssSign;

    // 전일 대비
    @Seq(5)
    public int prdyVrss;

    // 전일 대비율
    @Seq(6)
    public double prdyCtrt;

    // 가중 평균 주식 가격
    @Seq(7)
    public double wghnAvrgStckPrc;

    // 주식 시가
    @Seq(8)
    public int stckOprc;

    // 주식 최고가
    @Seq(9)
    public int stckHgpr;

    // 주식 최저가
    @Seq(10)
    public int stckLwpr;

    // 매도호가1
    @Seq(11)
    public int askp1;

    // 매수호가1
    @Seq(12)
    public int bidp1;

    // 체결 거래량
    @Seq(13)
    public long cntgVol;

    // 누적 거래량
    @Seq(14)
    public long acmlVol;

    // 누적 거래 대금
    @Seq(15)
    public long acmlTrPbmn;

    // 매도 체결 건수
    @Seq(16)
    public int selnCntgCsnu;

    // 매수 체결 건수
    @Seq(17)
    public int shnuCntgCsnu;

    // 순매수 체결 건수
    @Seq(18)
    public int ntbyCntgCsnu;

    // 체결강도
    @Seq(19)
    public double cttr;

    // 총 매도 수량
    @Seq(20)
    public long selnCntgSmtn;

    // 총 매수 수량
    @Seq(21)
    public long shnuCntgSmtn;

    // 체결구분
    @Seq(22)
    public String ccldDvsn;

    // 매수비율
    @Seq(23)
    public double shnuRate;

    // 전일 거래량 대비 등락율
    @Seq(24)
    public double prdyVolVrssAcmlVolRate;

    // 시가 시간
    @Seq(25)
    public String oprcHour;

    // 시가대비구분
    @Seq(26)
    public String oprcVrssPrprSign;

    // 시가대비
    @Seq(27)
    public int oprcVrssPrpr;

    // 최고가 시간
    @Seq(28)
    public String hgprHour;

    // 고가대비구분
    @Seq(29)
    public String hgprVrssPrprSign;

    // 고가대비
    @Seq(30)
    public int hgprVrssPrpr;

    // 최저가 시간
    @Seq(31)
    public String lwprHour;

    // 저가대비구분
    @Seq(32)
    public String lwprVrssPrprSign;

    // 저가대비
    @Seq(33)
    public int lwprVrssPrpr;

    // 영업 일자
    @Seq(34)
    public String bsopDate;

    // 신 장운영 구분 코드
    @Seq(35)
    public String newMkopClsCode;

    // 거래정지 여부
    @Seq(36)
    public String trhtYn;

    // 매도호가 잔량1
    @Seq(37)
    public long askpRsqn1;

    // 매수호가 잔량1
    @Seq(38)
    public long bidpRsqn1;

    // 총 매도호가 잔량
    @Seq(39)
    public long totalAskpRsqn;

    // 총 매수호가 잔량
    @Seq(40)
    public long totalBidpRsqn;

    // 거래량 회전율
    @Seq(41)
    public double volTnrt;

    // 전일 동시간 누적 거래량
    @Seq(42)
    public long prdySmnsHourAcmlVol;

    // 전일 동시간 누적 거래량 비율
    @Seq(43)
    public double prdySmnsHourAcmlVolRate;

    // 시간 구분 코드
    @Seq(44)
    public String hourClsCode;

    // 임의종료구분코드
    @Seq(45)
    public String mrktTrtmClsCode;

    // 정적VI발동기준가
    @Seq(46)
    public int viStndPrc;

}
