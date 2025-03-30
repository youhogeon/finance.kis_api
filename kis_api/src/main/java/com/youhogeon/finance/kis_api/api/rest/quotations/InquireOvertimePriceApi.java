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
 * 국내주식 시간외현재가[국내주식-076]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-overtime-price")
public class InquireOvertimePriceApi extends CommonRestApi<InquireOvertimePriceResult> {

    @Header
    private String trId = "FHPST02300000";

    /**
     * 조건 시장 분류 코드
     *
     * 시장구분코드 (주식 J)
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
