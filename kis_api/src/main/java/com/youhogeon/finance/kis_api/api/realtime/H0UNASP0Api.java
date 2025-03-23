package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 실시간호가 (통합) 요청
 */
@RealTimeApi(path = "/tryitout/H0UNASP0")
public class H0UNASP0Api extends CommonRealTimeApi<H0UNASP0Response> {

    public H0UNASP0Api(String trKey) {
        super("H0UNASP0", trKey);
    }

}
