package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * ELW 실시간호가 [실시간-062] 요청
 */
@RealTimeApi(path = "/tryitout/H0EWASP0")
public class H0EWASP0Api extends CommonRealTimeApi<H0EWASP0Response> {

    public H0EWASP0Api(String trKey) {
        super("H0EWASP0", trKey);
    }

}
