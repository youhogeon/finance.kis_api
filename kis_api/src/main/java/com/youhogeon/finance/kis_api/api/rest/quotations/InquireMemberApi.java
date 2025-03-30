package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 주식현재가 회원사[v1_국내주식-013]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-member")
public class InquireMemberApi extends CommonRestApi<InquireMemberResult> {

    @Header
    private String trId = "FHKST01010600";

    /**
     * FID 조건 시장 분류 코드
     *
     * J : 주식, ETF, ETN
     */
    @Parameter
    private String fidCondMrktDivCode = "J";

    /**
     * FID 입력 종목코드
     *
     * 종목번호 (6자리)ETN의 경우, Q로 시작 (EX. Q500001)
     */
    @Parameter
    @NonNull
    private String fidInputIscd;

}
