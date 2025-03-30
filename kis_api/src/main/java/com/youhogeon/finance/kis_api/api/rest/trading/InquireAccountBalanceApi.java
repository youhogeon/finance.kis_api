package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 투자계좌자산현황조회[v1_국내주식-048]
 */
@NoArgsConstructor
@Setter
@AccountRequired(location= AccountRequired.Location.PARAMETER)
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/inquire-account-balance")
public class InquireAccountBalanceApi extends CommonRestApi<InquireAccountBalanceResult> {

    @Header
    private String trId = "CTRP6548R";

    /**
     * 조회구분1
     *
     * 공백입력
     */
    @Parameter
    private String inqrDvsn1 = "";

    /**
     * 기준가이전일자적용여부
     *
     * 공백입력
     */
    @Parameter
    private String bsprBfDtAplyYn = "";

}
