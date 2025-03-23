package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.annotation.Seq;

import lombok.Data;
import lombok.ToString;

/**
 * 국내주식 장운영정보 (NXT) 실시간 데이터
 */
@Data
@ToString(callSuper = true)
public class H0NXMKO0Data implements RealTimeApiData {

    /** 종목코드 */
    @Seq(1)
    private String mkscShrnIscd;

    /** 거래정지 여부 */
    @Seq(2)
    private String trhtYn;

    /** 거래 정지 사유 내용 */
    @Seq(3)
    private String trSuspReasCntt;

    /** 장운영 구분 코드 */
    @Seq(4)
    private String mkopClsCode;

    /** 예상 장운영 구분 코드 */
    @Seq(5)
    private String antcMkopClsCode;

    /** 임의연장구분코드 */
    @Seq(6)
    private String mrktTrtmClsCode;

    /** 동시호가배분처리구분코드 */
    @Seq(7)
    private String diviAppClsCode;

    /** 종목상태구분코드 */
    @Seq(8)
    private String iscdStatClsCode;

    /** VI적용구분코드 */
    @Seq(9)
    private String viClsCode;

    /** 시간외단일가VI적용구분코드 */
    @Seq(10)
    private String ovtmViClsCode;

    /** 거래소 구분코드 */
    @Seq(11)
    private String exchClsCode;

}
