package com.youhogeon.finance.kis_api.api.rest;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.POST, path = "/uapi/domestic-stock/v1/trading/order-rvsecncl")
public class OrderRvsecnclApi extends CommonRestApi<OrderRvsecnclResult> {

    @Header
    private String trId = "TTTC0013U";

    @Body
    @NonNull
    private String krxFwdgOrdOrgno;

    @Body
    @NonNull
    private String orgnOdno;

    @Body
    private String ordDvsn = "00";

    @Body
    private String rvseCnclDvsnCd = "01"; // "01" 정정 "02" 취소

    @Body
    private String qrdQty = "0";

    @Body
    private String qrtUnpr = "0";

    @Body
    private String qtyAllOrdYn = "N";

    @Body
    private String cndtPric = "";

    @Body
    private String excgIdDvsnCd = "KRX";

}