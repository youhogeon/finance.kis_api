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
    
    @Header("tr_id")
    private String trId = "TTTC0013U";

    @Body("KRX_FWDG_ORD_ORGNO")
    @NonNull
    private String krxFwdgOrdOrgno;

    @Body("ORGN_ODNO")
    @NonNull
    private String orgnOdno;

    @Body("ORD_DVSN")
    private String ordDvsn = "00";

    @Body("RVSE_CNCL_DVSN_CD")
    private String rvseCnclDvsnCd = "01"; // "01" 정정 "02" 취소

    @Body("ORD_QTY")
    private String qrdQty = "0";

    @Body("ORD_UNPR")
    private String qrtUnpr = "0";

    @Body("QTY_ALL_ORD_YN")
    private String qtyAllOrdYn = "N";

    @Body("CNDT_PRIC")
    private String cndtPric = "";

    @Body("EXCG_ID_DVSN_CD")
    private String excgIdDvsnCd = "KRX";

}