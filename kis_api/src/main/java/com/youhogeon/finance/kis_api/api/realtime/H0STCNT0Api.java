package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

@RealTimeApi(path = "/tryitout/H0STCNT0")
public class H0STCNT0Api extends CommonRealTimeApi<H0STCNT0Result> {

    public H0STCNT0Api(String trKey) {
        super("H0STCNT0", trKey);
    }

}
