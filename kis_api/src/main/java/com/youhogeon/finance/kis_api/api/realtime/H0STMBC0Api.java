package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 실시간회원사 (KRX) [실시간-047] 요청
 */
@RealTimeApi(path = "/tryitout/H0STMBC0")
public class H0STMBC0Api extends CommonRealTimeApi<H0STMBC0Response> {

    public H0STMBC0Api(String trKey) {
        super("H0STMBC0", trKey);
    }

}
