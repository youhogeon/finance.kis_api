package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class EtfetnNavComparisonTimeTrendResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output[] output;

    @Getter
    @ToString
    public static class Output {

        /** 영업 시간 */
        private String bsopHour;

        /** NAV */
        private String nav;

        /** NAV 전일 대비 부호 */
        private String navPrdyVrssSign;

        /** NAV 전일 대비 */
        private String navPrdyVrss;

        /** NAV 전일 대비율 */
        private String navPrdyCtrt;

        /** NAV 대비 현재가 */
        private String navVrssPrpr;

        /** 괴리율 */
        private String dprt;

        /** 주식 현재가 */
        private String stckPrpr;

        /** 전일 대비 */
        private String prdyVrss;

        /** 전일 대비 부호 */
        private String prdyVrssSign;

        /** 전일 대비율 */
        private String prdyCtrt;

        /** 누적 거래량 */
        private String acmlVol;

        /** 체결 거래량 */
        private String cntgVol;
    }

}
