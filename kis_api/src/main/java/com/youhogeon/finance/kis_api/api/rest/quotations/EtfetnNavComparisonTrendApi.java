package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * NAV 비교추이(종목)[v1_국내주식-069]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@RestApi(method = RestApi.Method.GET, path = "/uapi/etfetn/v1/quotations/nav-comparison-trend")
public class EtfetnNavComparisonTrendApi extends CommonRestApi<EtfetnNavComparisonTrendResult> {

    @Header
    private String trId = "FHPST02440000";

    /**
     * 조건 시장 분류 코드
     *
     * J
     */
    @Parameter
    private String fidCondMrktDivCode = "J";

    /**
     * 입력 종목코드
     *
     * 종목코드
     */
    @Parameter
    @NonNull
    private String fidInputIscd;

}
