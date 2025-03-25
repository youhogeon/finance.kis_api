package com.youhogeon.finance.kis_api.api.rest;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.Setter;

@Setter
@AccountRequired(location = AccountRequired.Location.PARAMETER)
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/inquire-balance")
public class InquireBalanceApi extends CommonRestApi<InquireBalanceResult> {

   @Header("tr_id")
   private String trId = "TTTC8434R";

   @Parameter("AFHR_FLPR_YN")
   private String afhrFlprYn = "N";

   @Parameter("OFL_YN")
   private String oflYn = "";

   @Parameter("INQR_DVSN")
   private String inqrDvsn = "02";

   @Parameter("UNPR_DVSN")
   private String unprDvsn = "01";

   @Parameter("FUND_STTL_ICLD_YN")
   private String fundSttlIcldYn = "Y";

   @Parameter("FNCG_AMT_AUTO_RDPT_YN")
   private String fncgAmtAutoRdptYn = "N";

   @Parameter("PRCS_DVSN")
   private String prcsDvsn = "00";

   @Parameter("CTX_AREA_FK100")
   private String ctxAreaFk100 = "";

   @Parameter("CTX_AREA_NK100")
   private String ctxAreaNk100 = "";

}
