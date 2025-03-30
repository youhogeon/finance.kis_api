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
 * 국내주식기간별시세(일/주/월/년)[v1_국내주식-016]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-daily-itemchartprice")
public class InquireDailyItemchartpriceApi extends CommonRestApi<InquireDailyItemchartpriceResult> {

    @Header
    private String trId = "FHKST03010100";

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
     * 입력 날짜 1
     *
     * 조회 시작일자
     */
    @Parameter
    private String fidInputDate1;

    /**
     * 입력 날짜 2
     *
     * 조회 종료일자 (최대 100개)
     */
    @Parameter
    private String fidInputDate2;

    /**
     * 기간분류코드
     *
     * D:일봉 W:주봉, M:월봉, Y:년봉
     */
    @Parameter
    private String fidPeriodDivCode = "D";

    /**
     * 수정주가 원주가 가격 여부
     *
     * 0:수정주가 1:원주가
     */
    @Parameter
    private String fidOrgAdjPrc = "0";

}
