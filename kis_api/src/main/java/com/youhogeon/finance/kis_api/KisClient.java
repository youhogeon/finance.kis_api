package com.youhogeon.finance.kis_api;

import com.youhogeon.finance.kis_api.api.Api;
import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.config.Configuration;

public class KisClient {

    private Configuration config;

    public KisClient(Configuration config) {
        this.config = config;
    }

    public <T extends ApiResult> T execute(Api<T> api, String name) {
        return null;
    }


}
