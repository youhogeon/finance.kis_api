package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.LiveApi;

@LiveApi(path = "/tryitout/H0STCNT0")
public class H0STCNT0Request extends CommonLiveRequest<H0STCNT0Response> {

    public H0STCNT0Request(String trKey) {
        super("H0STCNT0", trKey);
    }

}
