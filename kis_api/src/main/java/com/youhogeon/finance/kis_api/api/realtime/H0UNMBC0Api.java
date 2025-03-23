package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 실시간회원사 (통합) 요청
 */
@RealTimeApi(path = "/tryitout/H0UNMBC0")
public class H0UNMBC0Api extends CommonRealTimeApi<H0UNMBC0Response> {

    public H0UNMBC0Api(String trKey) {
        super("H0UNMBC0", trKey);
    }

}
