package com.youhogeon.finance.kis_api.client.nothing;

import java.io.IOException;

import com.youhogeon.finance.kis_api.api.annotation.VirtualApi;
import com.youhogeon.finance.kis_api.client.NetworkClient;
import com.youhogeon.finance.kis_api.client.NetworkRequest;
import com.youhogeon.finance.kis_api.context.ApiContext;
import com.youhogeon.finance.kis_api.context.ApiData;

public class NothingClient implements NetworkClient {

    @Override
    public boolean isSupport(ApiData apiData) {
        return apiData.hasAnnotation(VirtualApi.class);
    }

    @Override
    public NetworkRequest makeRequest(ApiData apiData) {
        return null;
    }

    @Override
    public void execute(ApiContext context) throws IOException {

    }

    @Override
    public void close() throws IOException {

    }

}
