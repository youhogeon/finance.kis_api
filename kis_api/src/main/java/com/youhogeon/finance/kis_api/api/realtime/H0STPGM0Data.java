package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.ToString;

/**
 * 국내주식 실시간프로그램매매 (KRX) [실시간-048] 실시간 데이터
 */
@Data
@ToString(callSuper = true)
public class H0STPGM0Data implements RealTimeApiData {

    /** 유가증권단축종목코드 */
    @Seq(1)
    private String mkscShrnIscd;

    /** 주식체결시간 */
    @Seq(2)
    private String stckCntgHour;

    /** 매도체결량 */
    @Seq(3)
    private String selnCnqn;

    /** 매도거래대금 */
    @Seq(4)
    private String selnTrPbmn;

    /** 매수2체결량 */
    @Seq(5)
    private String shnuCnqn;

    /** 매수2거래대금 */
    @Seq(6)
    private String shnuTrPbmn;

    /** 순매수체결량 */
    @Seq(7)
    private String ntbyCnqn;

    /** 순매수거래대금 */
    @Seq(8)
    private String ntbyTrPbmn;

    /** 매도호가잔량 */
    @Seq(9)
    private String selnRsqn;

    /** 매수호가잔량 */
    @Seq(10)
    private String shnuRsqn;

    /** 전체순매수호가잔량 */
    @Seq(11)
    private String wholNtbyQty;

}
