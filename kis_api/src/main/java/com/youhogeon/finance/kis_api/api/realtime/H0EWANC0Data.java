package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.ToString;

/**
 * ELW 실시간예상체결 [실시간-063] 실시간 데이터
 */
@Data
@ToString(callSuper = true)
public class H0EWANC0Data implements RealTimeApiData {

    /** 성공 실패 여부 */
    @Seq(1)
    private String rtCd;

    /** 응답코드 */
    @Seq(2)
    private String msgCd;

    /** 응답메세지 */
    @Seq(3)
    private String msg1;

    /** 응답상세 */
    @Seq(4)
    private String output1;

    /** 유가증권단축종목코드 */
    @Seq(5)
    private String mkscShrnIscd;

    /** 주식체결시간 */
    @Seq(6)
    private String stckCntgHour;

    /** 주식현재가 */
    @Seq(7)
    private String stckPrpr;

    /** 전일대비부호 */
    @Seq(8)
    private String prdyVrssSign;

    /** 전일대비 */
    @Seq(9)
    private String prdyVrss;

    /** 전일대비율 */
    @Seq(10)
    private String prdyCtrt;

    /** 가중평균주식가격 */
    @Seq(11)
    private String wghnAvrgStckPrc;

    /** 주식시가2 */
    @Seq(12)
    private String stckOprc;

    /** 주식최고가 */
    @Seq(13)
    private String stckHgpr;

    /** 주식최저가 */
    @Seq(14)
    private String stckLwpr;

    /** 매도호가1 */
    @Seq(15)
    private String askp1;

    /** 매수호가1 */
    @Seq(16)
    private String bidp1;

    /** 체결거래량 */
    @Seq(17)
    private String cntgVol;

    /** 누적거래량 */
    @Seq(18)
    private String acmlVol;

    /** 누적거래대금 */
    @Seq(19)
    private String acmlTrPbmn;

    /** 매도체결건수 */
    @Seq(20)
    private String selnCntgCsnu;

    /** 매수체결건수 */
    @Seq(21)
    private String shnuCntgCsnu;

    /** 순매수체결건수 */
    @Seq(22)
    private String ntbyCntgCsnu;

    /** 체결강도 */
    @Seq(23)
    private String cttr;

    /** 총매도수량 */
    @Seq(24)
    private String selnCntgSmtn;

    /** 총매수수량 */
    @Seq(25)
    private String shnuCntgSmtn;

    /** 체결구분코드 */
    @Seq(26)
    private String cntgClsCode;

    /** 매수2비율 */
    @Seq(27)
    private String shnuRate;

    /** 전일거래량대비등락율 */
    @Seq(28)
    private String prdyVolVrssAcmlVolRate;

    /** 시가시간 */
    @Seq(29)
    private String oprcHour;

    /** 시가2대비현재가부호 */
    @Seq(30)
    private String oprcVrssPrprSign;

    /** 시가2대비현재가 */
    @Seq(31)
    private String oprcVrssPrpr;

    /** 최고가시간 */
    @Seq(32)
    private String hgprHour;

    /** 최고가대비현재가부호 */
    @Seq(33)
    private String hgprVrssPrprSign;

    /** 최고가대비현재가 */
    @Seq(34)
    private String hgprVrssPrpr;

    /** 최저가시간 */
    @Seq(35)
    private String lwprHour;

    /** 최저가대비현재가부호 */
    @Seq(36)
    private String lwprVrssPrprSign;

    /** 최저가대비현재가 */
    @Seq(37)
    private String lwprVrssPrpr;

    /** 영업일자 */
    @Seq(38)
    private String bsopDate;

    /** 신장운영구분코드 */
    @Seq(39)
    private String newMkopClsCode;

    /** 거래정지여부 */
    @Seq(40)
    private String trhtYn;

    /** 매도호가잔량1 */
    @Seq(41)
    private String askpRsqn1;

    /** 매수호가잔량1 */
    @Seq(42)
    private String bidpRsqn1;

    /** 총매도호가잔량 */
    @Seq(43)
    private String totalAskpRsqn;

    /** 총매수호가잔량 */
    @Seq(44)
    private String totalBidpRsqn;

    /** 시간가치값 */
    @Seq(45)
    private String tmvlVal;

    /** 패리티 */
    @Seq(46)
    private String prit;

    /** 프리미엄값 */
    @Seq(47)
    private String prmmVal;

    /** 기어링 */
    @Seq(48)
    private String gear;

    /** 손익분기비율 */
    @Seq(49)
    private String prlsQryrRate;

    /** 내재가치값 */
    @Seq(50)
    private String invlVal;

    /** 프리미엄비율 */
    @Seq(51)
    private String prmmRate;

    /** 자본지지점 */
    @Seq(52)
    private String cfp;

    /** 레버리지값 */
    @Seq(53)
    private String lvrgVal;

    /** 델타 */
    @Seq(54)
    private String delta;

    /** 감마 */
    @Seq(55)
    private String gama;

    /** 베가 */
    @Seq(56)
    private String vega;

    /** 세타 */
    @Seq(57)
    private String theta;

    /** 로우 */
    @Seq(58)
    private String rho;

    /** HTS내재변동성 */
    @Seq(59)
    private String htsIntsVltl;

    /** HTS이론가 */
    @Seq(60)
    private String htsThpr;

    /** 거래량회전율 */
    @Seq(61)
    private String volTnrt;

    /** LP보유량 */
    @Seq(62)
    private String lpHvol;

    /** LP보유비율 */
    @Seq(63)
    private String lpHldnRate;

}
