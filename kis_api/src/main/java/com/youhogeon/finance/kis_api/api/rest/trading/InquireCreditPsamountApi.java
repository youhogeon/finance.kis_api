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
 * 신용매수가능조회[v1_국내주식-042]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired(location= AccountRequired.Location.PARAMETER)
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/inquire-credit-psamount")
public class InquireCreditPsamountApi extends CommonRestApi<InquireCreditPsamountResult> {

    @Header
    private String trId = "TTTC8909R";

    /**
     * 상품번호
     *
     * 종목코드(6자리)
     */
    @Parameter
    @NonNull
    private String pdno;

    /**
     * 주문단가
     *
     * 1주당 가격
     * * 장전 시간외, 장후 시간외, 시장가의 경우 1주당 가격을 공란으로 비우지 않음 "0"으로 입력 권고
     */
    @Parameter
    @NonNull
    private String ordUnpr;

    /**
     * 주문구분
     *
     * 00 : 지정가
     * 01 : 시장가
     * 02 : 조건부지정가
     * 03 : 최유리지정가
     * 04 : 최우선지정가
     * 05 : 장전 시간외
     * 06 : 장후 시간외
     * 07 : 시간외 단일가  등
     */
    @Parameter
    private String ordDvsn = "00";

    /**
     * 신용유형
     *
     * 21 : 자기융자신규
     * 23 : 유통융자신규
     * 26 : 유통대주상환
     * 28 : 자기대주상환
     * 25 : 자기융자상환
     * 27 : 유통융자상환
     * 22 : 유통대주신규
     * 24 : 자기대주신규
     */
    @Parameter
    private String crdtType = "21";

    /**
     * CMA평가금액포함여부
     *
     * Y/N
     */
    @Parameter
    private String cmaEvluAmtIcldYn = "Y";

    /**
     * 해외포함여부
     *
     * Y/N
     */
    @Parameter
    private String ovrsIcldYn = "Y";

}
