package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 주식잔고조회_실현손익[v1_국내주식-041]
 */
@NoArgsConstructor
@Setter
@AccountRequired(location= AccountRequired.Location.PARAMETER)
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/inquire-balance-rlz-pl")
public class InquireBalanceRlzPlApi extends CommonRestApi<InquireBalanceRlzPlResult> {

    @Header
    private String trId = "TTTC8494R";

    /**
     * 시간외단일가여부
     *
     * N : 기본값
     * Y : 시간외단일가'
     */
    @Parameter
    private String afhrFlprYn = "N";

    /**
     * 오프라인여부
     *
     * 공란
     */
    @Parameter
    private String oflYn = "";

    /**
     * 조회구분
     *
     * 00 : 전체
     */
    @Parameter
    private String inqrDvsn = "00";

    /**
     * 단가구분
     *
     * 01 : 기본값
     */
    @Parameter
    private String unprDvsn = "01";

    /**
     * 펀드결제포함여부
     *
     * N : 포함하지 않음
     * Y : 포함
     */
    @Parameter
    private String fundSttlIcldYn = "Y";

    /**
     * 융자금액자동상환여부
     *
     * N : 기본값
     */
    @Parameter
    private String fncgAmtAutoRdptYn = "N";

    /**
     * PRCS_DVSN
     *
     * 00 : 전일매매포함
     * 01 : 전일매매미포함
     */
    @Parameter
    private String prcsDvsn = "00";

    /**
     * 비용포함여부
     */
    @Parameter
    private String costIcldYn = "";

    /**
     * 연속조회검색조건100
     *
     * 공란 : 최초 조회시
     * 이전 조회 Output CTX_AREA_FK100 값 : 다음페이지 조회시(2번째부터)
     */
    @Parameter
    private String ctxAreaFk100 = "";

    /**
     * 연속조회키100
     *
     * 공란 : 최초 조회시
     * 이전 조회 Output CTX_AREA_NK100 값 : 다음페이지 조회시(2번째부터)
     */
    @Parameter
    private String ctxAreaNk100 = "";

}
