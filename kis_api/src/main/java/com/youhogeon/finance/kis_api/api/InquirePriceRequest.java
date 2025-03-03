package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.URL;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Method;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;

@URL(method = Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-price")
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
public class InquirePriceRequest extends CommonRequest<InquirePriceResponse> {

    @Header("tr_id")
    private String trId = "FHKST01010100";

    @Parameter("FID_COND_MRKT_DIV_CODE")
    private String marketCode = "UN";

    @Parameter("FID_INPUT_ISCD")
    @NonNull
    private String code;

}
