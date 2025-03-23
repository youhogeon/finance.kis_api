package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.ToString;

/**
 * ELW 실시간호가 [실시간-062] 실시간 데이터
 */
@Data
@ToString(callSuper = true)
public class H0EWASP0Data implements RealTimeApiData {

    /** 성공 실패 여부 */
    @Seq(1)
    private String rtCd;

    /** 응답코드 */
    @Seq(2)
    private String msgCd;

    /** 응답상세 */
    @Seq(3)
    private String output1;

    /** 응답메세지 */
    @Seq(4)
    private String msg1;

    /** 유가증권단축종목코드 */
    @Seq(5)
    private String mkscShrnIscd;

    /** 영업시간 */
    @Seq(6)
    private String bsopHour;

    /** 시간구분코드 */
    @Seq(7)
    private String hourClsCode;

    /** 매도호가1 */
    @Seq(8)
    private String askp1;

    /** 매도호가2 */
    @Seq(9)
    private String askp2;

    /** 매도호가3 */
    @Seq(10)
    private String askp3;

    /** 매도호가4 */
    @Seq(11)
    private String askp4;

    /** 매도호가5 */
    @Seq(12)
    private String askp5;

    /** 매도호가6 */
    @Seq(13)
    private String askp6;

    /** 매도호가7 */
    @Seq(14)
    private String askp7;

    /** 매도호가8 */
    @Seq(15)
    private String askp8;

    /** 매도호가9 */
    @Seq(16)
    private String askp9;

    /** 매도호가10 */
    @Seq(17)
    private String askp10;

    /** 매수호가1 */
    @Seq(18)
    private String bidp1;

    /** 매수호가2 */
    @Seq(19)
    private String bidp2;

    /** 매수호가3 */
    @Seq(20)
    private String bidp3;

    /** 매수호가4 */
    @Seq(21)
    private String bidp4;

    /** 매수호가5 */
    @Seq(22)
    private String bidp5;

    /** 매수호가6 */
    @Seq(23)
    private String bidp6;

    /** 매수호가7 */
    @Seq(24)
    private String bidp7;

    /** 매수호가8 */
    @Seq(25)
    private String bidp8;

    /** 매수호가9 */
    @Seq(26)
    private String bidp9;

    /** 매수호가10 */
    @Seq(27)
    private String bidp10;

    /** 매도호가잔량1 */
    @Seq(28)
    private String askpRsqn1;

    /** 매도호가잔량2 */
    @Seq(29)
    private String askpRsqn2;

    /** 매도호가잔량3 */
    @Seq(30)
    private String askpRsqn3;

    /** 매도호가잔량4 */
    @Seq(31)
    private String askpRsqn4;

    /** 매도호가잔량5 */
    @Seq(32)
    private String askpRsqn5;

    /** 매도호가잔량6 */
    @Seq(33)
    private String askpRsqn6;

    /** 매도호가잔량7 */
    @Seq(34)
    private String askpRsqn7;

    /** 매도호가잔량8 */
    @Seq(35)
    private String askpRsqn8;

    /** 매도호가잔량9 */
    @Seq(36)
    private String askpRsqn9;

    /** 매도호가잔량10 */
    @Seq(37)
    private String askpRsqn10;

    /** 매수호가잔량1 */
    @Seq(38)
    private String bidpRsqn1;

    /** 매수호가잔량2 */
    @Seq(39)
    private String bidpRsqn2;

    /** 매수호가잔량3 */
    @Seq(40)
    private String bidpRsqn3;

    /** 매수호가잔량4 */
    @Seq(41)
    private String bidpRsqn4;

    /** 매수호가잔량5 */
    @Seq(42)
    private String bidpRsqn5;

    /** 매수호가잔량6 */
    @Seq(43)
    private String bidpRsqn6;

    /** 매수호가잔량7 */
    @Seq(44)
    private String bidpRsqn7;

    /** 매수호가잔량8 */
    @Seq(45)
    private String bidpRsqn8;

    /** 매수호가잔량9 */
    @Seq(46)
    private String bidpRsqn9;

    /** 매수호가잔량10 */
    @Seq(47)
    private String bidpRsqn10;

    /** 총매도호가잔량 */
    @Seq(48)
    private String totalAskpRsqn;

    /** 총매수호가잔량 */
    @Seq(49)
    private String totalBidpRsqn;

    /** 예상체결가 */
    @Seq(50)
    private String antcCnpr;

    /** 예상체결량 */
    @Seq(51)
    private String antcCnqn;

    /** 예상체결대비부호 */
    @Seq(52)
    private String antcCntgVrssSign;

    /** 예상체결대비 */
    @Seq(53)
    private String antcCntgVrss;

    /** 예상체결전일대비율 */
    @Seq(54)
    private String antcCntgPrdyCtrt;

    /** LP매도호가잔량1 */
    @Seq(55)
    private String lpAskpRsqn1;

    /** LP매도호가잔량2 */
    @Seq(56)
    private String lpAskpRsqn2;

    /** LP매도호가잔량3 */
    @Seq(57)
    private String lpAskpRsqn3;

    /** LP매수호가잔량4 */
    @Seq(58)
    private String lpBidpRsqn4;

    /** LP매도호가잔량4 */
    @Seq(59)
    private String lpAskpRsqn4;

    /** LP매수호가잔량5 */
    @Seq(60)
    private String lpBidpRsqn5;

    /** LP매도호가잔량5 */
    @Seq(61)
    private String lpAskpRsqn5;

    /** LP매수호가잔량6 */
    @Seq(62)
    private String lpBidpRsqn6;

    /** LP매도호가잔량6 */
    @Seq(63)
    private String lpAskpRsqn6;

    /** LP매수호가잔량7 */
    @Seq(64)
    private String lpBidpRsqn7;

    /** LP매도호가잔량7 */
    @Seq(65)
    private String lpAskpRsqn7;

    /** LP매도호가잔량8 */
    @Seq(66)
    private String lpAskpRsqn8;

    /** LP매수호가잔량8 */
    @Seq(67)
    private String lpBidpRsqn8;

    /** LP매도호가잔량9 */
    @Seq(68)
    private String lpAskpRsqn9;

    /** LP매수호가잔량9 */
    @Seq(69)
    private String lpBidpRsqn9;

    /** LP매도호가잔량10 */
    @Seq(70)
    private String lpAskpRsqn10;

    /** LP매수호가잔량10 */
    @Seq(71)
    private String lpBidpRsqn10;

    /** LP매수호가잔량1 */
    @Seq(72)
    private String lpBidpRsqn1;

    /** LP총매도호가잔량 */
    @Seq(73)
    private String lpTotalAskpRsqn;

    /** LP매수호가잔량2 */
    @Seq(74)
    private String lpBidpRsqn2;

    /** LP총매수호가잔량 */
    @Seq(75)
    private String lpTotalBidpRsqn;

    /** LP매수호가잔량3 */
    @Seq(76)
    private String lpBidpRsqn3;

    /** 예상거래량 */
    @Seq(77)
    private String antcVol;

}
