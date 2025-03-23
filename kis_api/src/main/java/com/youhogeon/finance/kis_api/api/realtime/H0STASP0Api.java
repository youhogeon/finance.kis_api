package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 실시간호가 (KRX) [실시간-004] 요청
 */
@RealTimeApi(path = "/tryitout/H0STASP0")
public class H0STASP0Api extends CommonRealTimeApi<H0STASP0Response> {

    public H0STASP0Api(String trKey) {
        super("H0STASP0", trKey);
    }

}
