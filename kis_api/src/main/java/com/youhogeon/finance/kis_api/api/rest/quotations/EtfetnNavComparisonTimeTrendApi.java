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
 * NAV 비교추이(분)[v1_국내주식-070]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/etfetn/v1/quotations/nav-comparison-time-trend")
public class EtfetnNavComparisonTimeTrendApi extends CommonRestApi<EtfetnNavComparisonTimeTrendResult> {

    @Header
    private String trId = "FHPST02440100";

    /**
     * FID 입력 종목코드
     *
     * 종목코드
     */
    @Parameter
    @NonNull
    private String fidInputIscd;

    /**
     * FID 시간 구분 코드
     *
     * 1분 :60, 3분: 180 … 120분:7200
     */
    @Parameter
    @NonNull
    private String fidHourClsCode;

    /**
     * FID 조건 시장 분류 코드
     *
     * E - 고정값
     */
    @Parameter
    private String fidCondMrktDivCode = "E";

}
