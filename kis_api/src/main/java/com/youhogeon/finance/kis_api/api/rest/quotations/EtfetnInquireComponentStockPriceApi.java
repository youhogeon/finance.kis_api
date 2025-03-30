package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * ETF 구성종목시세[국내주식-073]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/etfetn/v1/quotations/inquire-component-stock-price")
public class EtfetnInquireComponentStockPriceApi extends CommonRestApi<EtfetnInquireComponentStockPriceResult> {

    @Header
    private String trId = "FHKST121600C0";

    /**
     * 조건시장분류코드
     *
     * 시장구분코드 (J)
     */
    @Parameter
    private String fidCondMrktDivCode = "J";

    /**
     * 입력종목코드
     *
     * 종목코드
     */
    @Parameter
    @NonNull
    private String fidInputIscd;

    /**
     * 조건화면분류코드
     *
     * Unique key( 11216 )
     */
    @Parameter
    private String fidCondScrDivCode = "11216";

}
