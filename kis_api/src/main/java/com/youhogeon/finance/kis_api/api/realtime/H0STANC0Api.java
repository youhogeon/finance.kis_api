package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 실시간예상체결 (KRX) [실시간-041] 요청
 */
@RealTimeApi(path = "/tryitout/H0STANC0")
public class H0STANC0Api extends CommonRealTimeApi<H0STANC0Response> {

    public H0STANC0Api(String trKey) {
        super("H0STANC0", trKey);
    }

}
