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
 * 주식현재가 당일시간대별체결[v1_국내주식-023]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-time-itemconclusion")
public class InquireTimeItemconclusionApi extends CommonRestApi<InquireTimeItemconclusionResult> {

    @Header
    private String trId = "FHPST01060000";

    /**
     * 조건 시장 분류 코드
     *
     * J:KRX, NX:NXT, UN:통합
     */
    @Parameter
    private String fidCondMrktDivCode = "UN";

    /**
     * 입력 종목코드
     *
     * 종목코드 (ex 005930 삼성전자)
     */
    @Parameter
    @NonNull
    private String fidInputIscd;

    /**
     * 입력 시간1
     *
     * 입력시간
     */
    @Parameter
    private String fidInputHour1 = "";

}
