package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 시간외 실시간체결가 (KRX) [실시간-042] 요청
 */
@RealTimeApi(path = "/tryitout/H0STOUP0")
public class H0STOUP0Api extends CommonRealTimeApi<H0STOUP0Response> {

    public H0STOUP0Api(String trKey) {
        super("H0STOUP0", trKey);
    }

}
