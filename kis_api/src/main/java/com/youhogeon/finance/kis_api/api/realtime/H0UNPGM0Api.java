package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 실시간프로그램매매 (통합) 요청
 */
@RealTimeApi(path = "/tryitout/H0UNPGM0")
public class H0UNPGM0Api extends CommonRealTimeApi<H0UNPGM0Response> {

    public H0UNPGM0Api(String trKey) {
        super("H0UNPGM0", trKey);
    }

}
