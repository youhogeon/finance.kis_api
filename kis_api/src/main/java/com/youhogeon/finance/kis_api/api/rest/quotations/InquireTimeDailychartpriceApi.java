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
 * 주식일별분봉조회 [국내주식-213]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-time-dailychartprice")
public class InquireTimeDailychartpriceApi extends CommonRestApi<InquireTimeDailychartpriceResult> {

    @Header
    private String trId = "FHKST03010230";

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
     * 입력 시간(ex 13시 130000)
     */
    @Parameter
    @NonNull
    private String fidInputHour1;

    /**
     * 입력 날짜1
     *
     * 입력 날짜(20241023)
     */
    @Parameter
    @NonNull
    private String fidInputDate1;

    /**
     * 과거 데이터 포함 여부
     *
     *
     */
    @Parameter
    private String fidPwDataIncuYn = "";

    /**
     * 허봉 포함 여부
     *
     *
     */
    @Parameter
    private String fidFakeTickIncuYn = "";

}
