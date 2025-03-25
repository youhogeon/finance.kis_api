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
@RestApi(method = RestApi.Method.POST, path = "/uapi/domestic-stock/v1/trading/order-cash")
public class OrderCashApi extends CommonRestApi<OrderCashResult> {

    @Header("tr_id")
    private String trId = "TTTC0012U"; // 매도 : TTTC0011U

    @Body("PDNO")
    @NonNull
    private String pdno;

    @Body("SLL_TYPE")
    private String sllType = "01";

    @Body("ORD_DVSN")
    private String ordDvsn = "00";

    @Body("ORD_QTY")
    @NonNull
    private String qrdQty;

    @Body("ORD_UNPR")
    @NonNull
    private String qrtUnpr;

    @Body("CNDT_PRIC")
    private String cndtPric = "";

    @Body("EXCG_ID_DVSN_CD")
    private String excgIdDvsnCd = "KRX";

}
