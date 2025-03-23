package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내지수 실시간프로그램매매 [실시간-028] 요청
 */
@RealTimeApi(path = "/tryitout/H0UPPGM0")
public class H0UPPGM0Api extends CommonRealTimeApi<H0UPPGM0Response> {

    public H0UPPGM0Api(String trKey) {
        super("H0UPPGM0", trKey);
    }

}
