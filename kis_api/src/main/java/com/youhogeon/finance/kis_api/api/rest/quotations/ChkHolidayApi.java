package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 국내휴장일조회[국내주식-040]
 */
@RequiredArgsConstructor
@Setter
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/chk-holiday")
public class ChkHolidayApi extends CommonRestApi<ChkHolidayApiResult>  {

    @Header("tr_id")
    private String trId = "CTCA0903R";

    @Parameter
    @NonNull
    private String bassDt; // 기준일자 (YYYYMMDD)

    @Parameter
    private String ctxAreaNk = "";

    @Parameter
    private String ctxAreaFk = "";

}
