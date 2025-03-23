package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 실시간회원사 (NXT) 요청
 */
@RealTimeApi(path = "/tryitout/H0NXMBC0")
public class H0NXMBC0Api extends CommonRealTimeApi<H0NXMBC0Response> {

    public H0NXMBC0Api(String trKey) {
        super("H0NXMBC0", trKey);
    }

}
