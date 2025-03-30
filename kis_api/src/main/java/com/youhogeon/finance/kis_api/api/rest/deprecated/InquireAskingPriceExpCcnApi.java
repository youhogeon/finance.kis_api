package com.youhogeon.finance.kis_api.api.rest.deprecated;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-asking-price-exp-ccn")
public class InquireAskingPriceExpCcnApi extends CommonRestApi<InquireAskingPriceExpCcnResult>  {

    @Header
    private String trId = "FHKST01010200";

    /** 조건 시장 분류 코드	(J:KRX, NX:NXT, UN:통합) */
    @Parameter
    private String fidCondMrktDivCode = "UN";

    /** 입력 종목코드 */
    @Parameter
    @NonNull
    private String fidInputIscd;

    public InquireAskingPriceExpCcnApi(String fidCondMrktDivCode, String fidInputIscd) {
        this.fidCondMrktDivCode = fidCondMrktDivCode;
        this.fidInputIscd = fidInputIscd;
    }

}
