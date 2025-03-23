package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내ETF NAV추이 [실시간-051] 요청
 */
@RealTimeApi(path = "/tryitout/H0STNAV0")
public class H0STNAV0Api extends CommonRealTimeApi<H0STNAV0Response> {

    public H0STNAV0Api(String trKey) {
        super("H0STNAV0", trKey);
    }

}
