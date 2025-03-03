package com.youhogeon.finance.kis_api.client.http;

import java.io.IOException;

public interface HttpClient {

    public HttpClientResponse execute(HttpClientRequest request) throws IOException;

}
