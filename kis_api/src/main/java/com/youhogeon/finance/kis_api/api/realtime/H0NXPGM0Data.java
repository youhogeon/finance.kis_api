package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.ToString;

/**
 * 국내주식 실시간프로그램매매 (NXT) 실시간 데이터
 */
@Data
@ToString(callSuper = true)
public class H0NXPGM0Data implements RealTimeApiData {

    /** 유가증권 단축 종목코드 */
    @Seq(1)
    private String mkscShrnIscd;

    /** 주식 체결 시간 */
    @Seq(2)
    private String stckCntgHour;

    /** 매도 체결량 */
    @Seq(3)
    private String selnCnqn;

    /** 매도 거래 대금 */
    @Seq(4)
    private String selnTrPbmn;

    /** 매수2 체결량 */
    @Seq(5)
    private String shnuCnqn;

    /** 매수2 거래 대금 */
    @Seq(6)
    private String shnuTrPbmn;

    /** 순매수 체결량 */
    @Seq(7)
    private String ntbyCnqn;

    /** 순매수 거래 대금 */
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
