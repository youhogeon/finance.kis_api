package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 주식정정취소가능주문조회[v1_국내주식-004]
 */
@NoArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/inquire-psbl-rvsecncl")
public class InquirePsblRvsecnclApi extends CommonRestApi<InquirePsblRvsecnclResult> {

    @Header
    private String trId = "TTTC0084R";

    /**
     * 조회구분1
     *
     * '0 주문
     * 1 종목'
     */
    @Parameter
    private String inqrDvsn1 = "0";

    /**
     * 조회구분2
     *
     * '0 전체
     * 1 매도
     * 2 매수'
     */
    @Parameter
    private String inqrDvsn2 = "0";

    /**
     * 연속조회검색조건100
     *
     * '공란 : 최초 조회시는
     * 이전 조회 Output CTX_AREA_FK100 값 : 다음페이지 조회시(2번째부터)'
     */
    @Parameter
    private String ctxAreaFk100 = "";

    /**
     * 연속조회키100
     *
     * '공란 : 최초 조회시
     * 이전 조회 Output CTX_AREA_NK100 값 : 다음페이지 조회시(2번째부터)'
     */
    @Parameter
    private String ctxAreaNk100 = "";

}
