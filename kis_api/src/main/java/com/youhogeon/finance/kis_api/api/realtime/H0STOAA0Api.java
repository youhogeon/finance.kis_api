package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 시간외 실시간호가 (KRX) [실시간-025] 요청
 */
@RealTimeApi(path = "/tryitout/H0STOAA0")
public class H0STOAA0Api extends CommonRealTimeApi<H0STOAA0Response> {

    public H0STOAA0Api(String trKey) {
        super("H0STOAA0", trKey);
    }

}
