package com.youhogeon.finance.kis_api.client;

import java.io.IOException;

import com.youhogeon.finance.kis_api.context.ApiContext;
import com.youhogeon.finance.kis_api.context.ApiData;

public interface NetworkClient {

    public boolean isSupport(ApiData apiData);

    public NetworkRequest makeRequest(ApiData apiData);
    public void execute(ApiContext context) throws IOException;

    public void close() throws IOException;

}
