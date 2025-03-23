package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 실시간체결가 (통합) 요청
 */
@RealTimeApi(path = "/tryitout/H0UNCNT0")
public class H0UNCNT0Api extends CommonRealTimeApi<H0UNCNT0Response> {

    public H0UNCNT0Api(String trKey) {
        super("H0UNCNT0", trKey);
    }

}
