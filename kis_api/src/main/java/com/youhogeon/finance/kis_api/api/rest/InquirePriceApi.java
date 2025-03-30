package com.youhogeon.finance.kis_api.api.rest;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-price")
public class InquirePriceApi extends CommonRestApi<InquirePriceResult> {

    @Header
    private String trId = "FHKST01010100";

    @Parameter("FID_COND_MRKT_DIV_CODE")
    private String marketCode = "UN";

    @Parameter("FID_INPUT_ISCD")
    @NonNull
    private String code;

}
