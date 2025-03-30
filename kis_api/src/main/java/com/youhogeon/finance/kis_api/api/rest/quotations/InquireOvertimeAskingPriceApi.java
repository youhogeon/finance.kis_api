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
 * 국내주식 시간외호가[국내주식-077]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-overtime-asking-price")
public class InquireOvertimeAskingPriceApi extends CommonRestApi<InquireOvertimeAskingPriceResult> {

    @Header
    private String trId = "FHPST02300400";

    /**
     * 입력 종목코드
     *
     * 종목코드
     */
    @Parameter
    @NonNull
    private String fidInputIscd;

    /**
     * 조건 시장 분류 코드
     *
     * 시장구분코드 (주식 J)
     */
    @Parameter
    private String fidCondMrktDivCode = "J";

}
