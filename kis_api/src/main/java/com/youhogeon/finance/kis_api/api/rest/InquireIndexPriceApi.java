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
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-index-price")
public class InquireIndexPriceApi extends CommonRestApi<InquireIndexPriceResult> {

    @Header("tr_id")
    private String trId = "FHPUP02100000";

    @Parameter("FID_INPUT_ISCD")
    @NonNull
    private String fidInputIscd; // 코스피(0001), 코스닥(1001), 코스피200(2001)

    @Parameter("FID_COND_MRKT_DIV_CODE")
    private String fidCondMrktDivCode = "U";

}
