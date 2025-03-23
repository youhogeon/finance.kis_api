package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 시간외 실시간예상체결 (KRX) [실시간-024] 요청
 */
@RealTimeApi(path = "/tryitout/H0STOAC0")
public class H0STOAC0Api extends CommonRealTimeApi<H0STOAC0Response> {

    public H0STOAC0Api(String trKey) {
        super("H0STOAC0", trKey);
    }

}
