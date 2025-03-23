package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * ELW 실시간체결가 [실시간-061] 요청
 */
@RealTimeApi(path = "/tryitout/H0EWCNT0")
public class H0EWCNT0Api extends CommonRealTimeApi<H0EWCNT0Response> {

    public H0EWCNT0Api(String trKey) {
        super("H0EWCNT0", trKey);
    }

}
