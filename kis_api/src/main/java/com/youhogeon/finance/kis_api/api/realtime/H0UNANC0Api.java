package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 실시간예상체결 (통합) 요청
 */
@RealTimeApi(path = "/tryitout/H0UNANC0")
public class H0UNANC0Api extends CommonRealTimeApi<H0UNANC0Response> {

    public H0UNANC0Api(String trKey) {
        super("H0UNANC0", trKey);
    }

}
