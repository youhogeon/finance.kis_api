package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 실시간호가 (NXT) 요청
 */
@RealTimeApi(path = "/tryitout/H0NXASP0")
public class H0NXASP0Api extends CommonRealTimeApi<H0NXASP0Response> {

    public H0NXASP0Api(String trKey) {
        super("H0NXASP0", trKey);
    }

}
