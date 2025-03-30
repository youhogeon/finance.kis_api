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
 * 기간별계좌권리현황조회 [국내주식-211]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/period-rights")
public class PeriodRightsApi extends CommonRestApi<PeriodRightsResult> {

    @Header
    private String trId = "CTRGA011R";

    /**
     * 조회구분
     *
     * 03 입력
     */
    @Parameter
    private String inqrDvsn = "03";

    /**
     * 고객실명확인번호25
     *
     * 공란
     */
    @Parameter
    private String custRncno25 = "";

    /**
     * 홈넷ID
     *
     * 공란
     */
    @Parameter
    private String hmid = "";

    /**
     * 조회시작일자
     *
     * 조회시작일자(YYYYMMDD)
     */
    @Parameter
    @NonNull
    private String inqrStrtDt;

    /**
     * 조회종료일자
     *
     * 조회종료일자(YYYYMMDD)
     */
    @Parameter
    @NonNull
    private String inqrEndDt;

    /**
     * 권리유형코드
     *
     * 공란
     */
    @Parameter
    private String rghtTypeCd = "";

    /**
     * 상품번호
     *
     * 공란
     */
    @Parameter
    private String pdno = "";

    /**
     * 상품유형코드
     *
     * 공란
     */
    @Parameter
    private String prdtTypeCd = "";

    /**
     * 연속조회키100
     *
     * 다음조회시 입력
     */
    @Parameter
    private String ctxAreaNk100 = "";

    /**
     * 연속조회검색조건100
     *
     * 다음조회시 입력
     */
    @Parameter
    private String ctxAreaFk100 = "";

}
