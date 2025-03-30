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
 * 주식당일분봉조회[v1_국내주식-022]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-time-itemchartprice")
public class InquireTimeItemchartpriceApi extends CommonRestApi<InquireTimeItemchartpriceResult> {

    @Header
    private String trId = "FHKST03010200";

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

    /**
     * 과거 데이터 포함 여부
     *
     *
     */
    @Parameter
    private String fidPwDataIncuYn = "";

    /**
     * 기타 구분 코드
     *
     *
     */
    @Parameter
    private String fidEtcClsCode = "";

}
