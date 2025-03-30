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
 * 주식현재가 시세2[v1_국내주식-054]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-price-2")
public class InquirePrice2Api extends CommonRestApi<InquirePrice2Result> {

    @Header
    private String trId = "FHPST01010000";

    /**
     * FID 조건 시장 분류 코드
     *
     * J : 주식, ETF, ETN
     */
    @Parameter
    private String fidCondMrktDivCode = "J";

    /**
     * FID 입력 종목코드
     *
     * 000660
     */
    @Parameter
    @NonNull
    private String fidInputIscd;

}
