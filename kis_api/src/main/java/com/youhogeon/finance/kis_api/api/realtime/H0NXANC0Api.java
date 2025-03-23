package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 실시간예상체결 (NXT) 요청
 */
@RealTimeApi(path = "/tryitout/H0NXANC0")
public class H0NXANC0Api extends CommonRealTimeApi<H0NXANC0Response> {

    public H0NXANC0Api(String trKey) {
        super("H0NXANC0", trKey);
    }

}
