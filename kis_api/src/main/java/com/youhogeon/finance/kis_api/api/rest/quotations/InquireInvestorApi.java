package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 주식현재가 투자자[v1_국내주식-012]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-investor")
public class InquireInvestorApi extends CommonRestApi<InquireInvestorResult> {

    @Header
    private String trId = "FHKST01010900";

    /**
     * 조건 시장 분류 코드
     *
     * J:KRX
     */
    @Parameter
    private String fidCondMrktDivCode = "J";

    /**
     * 입력 종목코드
     *
     * 종목코드 (ex 005930 삼성전자)
     */
    @Parameter
    @NonNull
    private String fidInputIscd;

}
