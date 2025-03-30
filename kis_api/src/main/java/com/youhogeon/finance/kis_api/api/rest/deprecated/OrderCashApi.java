package com.youhogeon.finance.kis_api.api.rest.deprecated;

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

    @Header
    private String trId = "TTTC0012U"; // 매도 : TTTC0011U

    @Body
    @NonNull
    private String pdno;

    @Body
    private String sllType = "01";

    @Body
    private String ordDvsn = "00";

    @Body
    @NonNull
    private String qrdQty;

    @Body
    @NonNull
    private String qrtUnpr;

    @Body
    private String cndtPric = "";

    @Body
    private String excgIdDvsnCd = "KRX";

}
