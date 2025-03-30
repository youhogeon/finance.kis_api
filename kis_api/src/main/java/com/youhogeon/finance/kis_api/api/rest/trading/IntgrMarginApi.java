package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 주식통합증거금 현황 [국내주식-191]
 */
@NoArgsConstructor
@Setter
@AccountRequired(location= AccountRequired.Location.PARAMETER)
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/intgr-margin")
public class IntgrMarginApi extends CommonRestApi<IntgrMarginResult> {

    @Header
    private String trId = "TTTC0869R";

    /**
     * CMA평가금액포함여부
     *
     * N 입력
     */
    @Parameter
    private String cmaEvluAmtIcldYn = "N";

    /**
     * 원화외화구분코드
     *
     * 01(외화기준),02(원화기준)
     */
    @Parameter
    private String wcrcFrcrDvsnCd = "01";

    /**
     * 선도환계약외화구분코드
     *
     * 01(외화기준),02(원화기준)
     */
    @Parameter
    private String fwexCtrtFrcrDvsnCd = "01";

}
