package com.youhogeon.finance.kis_api.api.rest;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/chk-holiday")
public class ChkHolidayApi extends CommonRestApi<ChkHolidayApiResult>  {

    @Header("tr_id")
    private String trId = "CTCA0903R";

    @Parameter("BASS_DT")
    @NonNull
    private String bassDt; // 기준일자 (YYYYMMDD)

    @Parameter("CTX_AREA_NK")
    private String ctxAreaNk = "";

    @Parameter("CTX_AREA_FK")
    private String ctxAreaFk = "";

}
