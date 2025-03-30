package com.youhogeon.finance.kis_api.api.rest.deprecated;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@AccountRequired(location = AccountRequired.Location.PARAMETER)
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/inquire-daily-ccld")
public class InquireDailyCcldApi extends CommonRestApi<InquireDailyCcldResult>  {

    @Header
    private String trId = "TTTC0081R";

    @Parameter
    @NonNull
    private String inqrStrtDt;

    @Parameter
    @NonNull
    private String inqrEndDt;

    @Parameter
    private String sllBuyDvsnCd = "00";

    @Parameter
    private String pdno = "";

    @Parameter
    private String ordGnoBrno = "";

    @Parameter
    private String odno = "";

    @Parameter
    private String ccldDvsn = "00";

    @Parameter
    private String inqrDvsn = "00";

    @Parameter
    private String inqrDvsn1 = "";

    @Parameter
    private String inqrDvsn3 = "00";

    @Parameter
    private String excgIdDvsnCd = "KRX";

    @Parameter
    private String ctxAreaFk100 = "";

    @Parameter
    private String ctxAreaNk100 = "";

}