package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내지수 실시간예상체결 [실시간-027] 요청
 */
@RealTimeApi(path = "/tryitout/H0UPANC0")
public class H0UPANC0Api extends CommonRealTimeApi<H0UPANC0Response> {

    public H0UPANC0Api(String trKey) {
        super("H0UPANC0", trKey);
    }

}
