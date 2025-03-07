package com.youhogeon.finance.kis_api.client.socket;


import com.youhogeon.finance.kis_api.api.annotation.LiveApi;
import com.youhogeon.finance.kis_api.client.NetworkClient;
import com.youhogeon.finance.kis_api.context.ApiData;

public abstract class SocketClient implements NetworkClient {

    public boolean isSupport(ApiData data) {
        return data.hasAnnotation(LiveApi.class);
    }

}
