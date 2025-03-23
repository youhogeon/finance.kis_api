package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.ToString;

/**
 * 국내ETF NAV추이 [실시간-051] 실시간 데이터
 */
@Data
@ToString(callSuper = true)
public class H0STNAV0Data implements RealTimeApiData {

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

    /** NAV */
    @Seq(6)
    private String nav;

    /** NAV전일대비부호 */
    @Seq(7)
    private String navPrdyVrssSign;

    /** NAV전일대비 */
    @Seq(8)
    private String navPrdyVrss;

    /** NAV전일대비율 */
    @Seq(9)
    private String navPrdyCtrt;

    /** NAV시가 */
    @Seq(10)
    private String oprcNav;

    /** NAV고가 */
    @Seq(11)
    private String hprcNav;

    /** NAV저가 */
    @Seq(12)
    private String lprcNav;

}
