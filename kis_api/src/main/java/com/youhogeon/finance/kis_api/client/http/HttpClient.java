package com.youhogeon.finance.kis_api.client.http;

import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.client.NetworkClient;
import com.youhogeon.finance.kis_api.context.ApiData;

public abstract class HttpClient implements NetworkClient {

    public boolean isSupport(ApiData apiData) {
        return apiData.hasAnnotation(RestApi.class);
    }

}
