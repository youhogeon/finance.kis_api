package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 퇴직연금 체결기준잔고[v1_국내주식-032]
 */
@NoArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/pension/inquire-present-balance")
public class PensionInquirePresentBalanceApi extends CommonRestApi<PensionInquirePresentBalanceResult> {

    @Header
    private String trId = "TTTC2202R";

    /**
     * 사용자구분코드
     *
     * 00
     */
    @Parameter
    private String userDvsnCd = "00";

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
