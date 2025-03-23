package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 실시간프로그램매매 (NXT) 요청
 */
@RealTimeApi(path = "/tryitout/H0NXPGM0")
public class H0NXPGM0Api extends CommonRealTimeApi<H0NXPGM0Response> {

    public H0NXPGM0Api(String trKey) {
        super("H0NXPGM0", trKey);
    }

}
