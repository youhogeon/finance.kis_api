package com.youhogeon.finance.kis_api.api.rest.deprecated;

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

   @Header
   private String trId = "TTTC8434R";

   @Parameter
   private String afhrFlprYn = "N";

   @Parameter
   private String oflYn = "";

   @Parameter
   private String inqrDvsn = "02";

   @Parameter
   private String unprDvsn = "01";

   @Parameter
   private String fundSttlIcldYn = "Y";

   @Parameter
   private String fncgAmtAutoRdptYn = "N";

   @Parameter
   private String prcsDvsn = "00";

   @Parameter
   private String ctxAreaFk100 = "";

   @Parameter
   private String ctxAreaNk100 = "";

}
