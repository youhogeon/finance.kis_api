package com.youhogeon.finance.kis_api.api.rest;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;

import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/inquire-balance")
public class InquireBalanceApi extends CommonRestApi<InquireBalanceResult> {

    @Parameter("CANO")
    private String cano;

    @Parameter("ACNT_PRDT_CD")
    private String acntPrdtCd;

    @Parameter("AFHR_FLPR_YN")
    private String afhrFlprYn;

    @Parameter("OFL_YN")
    private String oflYn;

    @Parameter("INQR_DVSN")
    private String inqrDvsn;

    @Parameter("UNPR_DVSN")
    private String unprDvsn;

    @Parameter("FUND_STTL_ICLD_YN")
    private String fundSttlIcldYn;

    @Parameter("FNCG_AMT_AUTO_RDPT_YN")
    private String fncgAmtAutoRdptYn;

    @Parameter("PRCS_DVSN")
    private String prcsDvsn;

    @Parameter("CTX_AREA_FK100")
    private String ctxAreaFk100;

    @Parameter("CTX_AREA_NK100")
    private String ctxAreaNk100;


}
