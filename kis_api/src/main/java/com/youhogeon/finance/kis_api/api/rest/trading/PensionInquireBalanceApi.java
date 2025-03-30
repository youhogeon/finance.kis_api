package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 퇴직연금 잔고조회[v1_국내주식-036]
 */
@NoArgsConstructor
@Setter
@AccountRequired(location= AccountRequired.Location.PARAMETER)
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/pension/inquire-balance")
public class PensionInquireBalanceApi extends CommonRestApi<PensionInquireBalanceResult> {

    @Header
    private String trId = "TTTC2208R";

    /**
     * 적립금구분코드
     */
    @Parameter
    private String accaDvsnCd = "00";

    /**
     * 조회구분
     *
     * 00 : 전체
     */
    @Parameter
    private String inqrDvsn = "00";

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
