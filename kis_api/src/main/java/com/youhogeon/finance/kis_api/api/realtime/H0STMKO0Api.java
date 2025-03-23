package com.youhogeon.finance.kis_api.api.realtime;

import com.youhogeon.finance.kis_api.api.CommonRealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;

/**
 * 국내주식 장운영정보 (KRX) [실시간-049] 요청
 */
@RealTimeApi(path = "/tryitout/H0STMKO0")
public class H0STMKO0Api extends CommonRealTimeApi<H0STMKO0Response> {

    public H0STMKO0Api(String trKey) {
        super("H0STMKO0", trKey);
    }

}
