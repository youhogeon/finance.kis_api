package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.ToString;

/**
 * 국내주식 실시간체결통보 [실시간-005] 실시간 데이터
 */
@Data
@ToString(callSuper = true)
public class H0STCNI0Data implements RealTimeApiData {

    /** 고객 ID */
    @Seq(1)
    private String custId;

    /** 계좌번호 */
    @Seq(2)
    private String acntNo;

    /** 주문번호 */
    @Seq(3)
    private String oderNo;

    /** 원주문번호 */
    @Seq(4)
    private String ooderNo;

    /** 매도매수구분 */
    @Seq(5)
    private String selnByovCls;

    /** 정정구분 */
    @Seq(6)
    private String rctfCls;

    /** 주문종류 */
    @Seq(7)
    private String oderKind;

    /** 주문조건 */
    @Seq(8)
    private String oderCond;

    /** 주식 단축 종목코드 */
    @Seq(9)
    private String stckShrnIscd;

    /** 체결 수량 */
    @Seq(10)
    private String cntgQty;

    /** 체결단가 */
    @Seq(11)
    private String cntgUnpr;

    /** 주식 체결 시간 */
    @Seq(12)
    private String stckCntgHour;

    /** 거부여부 */
    @Seq(13)
    private String rfusYn;

    /** 체결여부 */
    @Seq(14)
    private String cntgYn;

    /** 접수여부 */
    @Seq(15)
    private String acptYn;

    /** 지점번호 */
    @Seq(16)
    private String brncNo;

    /** 주문수량 */
    @Seq(17)
    private String oderQty;

    /** 계좌명 */
    @Seq(18)
    private String acntName;

    /** 호가조건가격 */
    @Seq(19)
    private String ordCondPrc;

    /** 주문거래소 구분 */
    @Seq(20)
    private String ordExgGb;

    /** 실시간체결창 표시여부 */
    @Seq(21)
    private String popupYn;

    /** 필러 */
    @Seq(22)
    private String filler;

    /** 신용구분 */
    @Seq(23)
    private String crdtCls;

    /** 신용대출일자 */
    @Seq(24)
    private String crdtLoanDate;

    /** 체결종목명 */
    @Seq(25)
    private String cntgIsnm40;

    /** 주문가격 */
    @Seq(26)
    private String oderPrc;

}
