package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 퇴직연금 미체결내역[v1_국내주식-033]
 */
@NoArgsConstructor
@Setter
@AccountRequired(location= AccountRequired.Location.PARAMETER)
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/pension/inquire-daily-ccld")
public class PensionInquireDailyCcldApi extends CommonRestApi<PensionInquireDailyCcldResult> {

    @Header
    private String trId = "TTTC2201R";

    /**
     * 사용자구분코드
     */
    @Parameter
    private String userDvsnCd = "00";

    /**
     * 매도매수구분코드
     *
     * 00 : 전체 / 01 : 매도 / 02 : 매수
     */
    @Parameter
    private String sllBuyDvsnCd = "00";

    /**
     * 체결미체결구분
     *
     * 00 : 전체 / 01 : 체결 / 02 : 미체결
     */
    @Parameter
    private String ccldNccsDvsn = "00";

    /**
     * 조회구분3
     *
     * 00 : 전체
     */
    @Parameter
    private String inqrDvsn3 = "00";

    /**
     * 연속조회검색조건100
     */
    @Parameter
    private String ctxAreaFk100 = "";

    /**
     * 연속조회키100
     */
    @Parameter
    private String ctxAreaNk100 = "";

}
