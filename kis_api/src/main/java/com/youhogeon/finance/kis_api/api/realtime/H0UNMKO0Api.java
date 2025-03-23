package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 장운영정보 (통합) 요청
 */
@RealTimeApi(path = "/tryitout/H0UNMKO0")
public class H0UNMKO0Api extends CommonRealTimeApi<H0UNMKO0Response> {

    public H0UNMKO0Api(String trKey) {
        super("H0UNMKO0", trKey);
    }

}
