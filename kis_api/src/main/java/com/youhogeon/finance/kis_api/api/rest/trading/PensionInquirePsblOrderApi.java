package com.youhogeon.finance.kis_api.api.rest.trading;

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
 * 퇴직연금 매수가능조회[v1_국내주식-034]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired(location= AccountRequired.Location.PARAMETER)
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/pension/inquire-psbl-order")
public class PensionInquirePsblOrderApi extends CommonRestApi<PensionInquirePsblOrderResult> {

    @Header
    private String trId = "TTTC0503R";

    /**
     * 상품번호
     */
    @Parameter
    @NonNull
    private String pdno;

    /**
     * 적립금구분코드
     *
     * 00
     */
    @Parameter
    private String accaDvsnCd = "00";

    /**
     * CMA평가금액포함여부
     */
    @Parameter
    private String cmaEvluAmtIcldYn = "Y";

    /**
     * 주문구분
     *
     * 00 : 지정가 / 01 : 시장가
     */
    @Parameter
    private String ordDvsn = "00";

    /**
     * 주문단가
     */
    @Parameter
    @NonNull
    private String ordUnpr;

}
