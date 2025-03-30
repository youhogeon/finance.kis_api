package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 주식잔고조회[v1_국내주식-006]
 */
@NoArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/inquire-balance")
public class InquireBalanceApi extends CommonRestApi<InquireBalanceResult> {

    /**
     * [실전투자]
     * TTTC8434R : 주식 잔고 조회
     *
     * [모의투자]
     * VTTC8434R : 주식 잔고 조회
     */
    @Header
    private String trId = "TTTC8434R";

    /**
     * 시간외단일가, 거래소여부
     *
     * N : 기본값,
     * Y : 시간외단일가,
     * X : NXT 정규장 (프리마켓, 메인, 애프터마켓)
     * ※ NXT 선택 시 : NXT 거래종목만 시세 등 정보가 NXT 기준으로 변동됩니다. KRX 종목들은 그대로 유지
     */
    @Parameter
    private String afhrFlprYn = "N";

    /**
     * 오프라인여부
     *
     * 공란(Default)
     */
    @Parameter
    private String oflYn = "";

    /**
     * 조회구분
     *
     * 01 : 대출일별
     * 02 : 종목별
     */
    @Parameter
    private String inqrDvsn = "01";

    /**
     * 단가구분
     *
     * 01 : 기본값
     */
    @Parameter
    private String unprDvsn = "01";

    /**
     * 펀드결제분포함여부
     *
     * N : 포함하지 않음
     * Y :  포함
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
     * 처리구분
     *
     * 00 : 전일매매포함
     * 01 : 전일매매미포함
     */
    @Parameter
    private String prcsDvsn = "00";

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
