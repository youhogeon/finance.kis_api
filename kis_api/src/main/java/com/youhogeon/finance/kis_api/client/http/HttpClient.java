package com.youhogeon.finance.kis_api.client.http;

public interface HttpClient {

    public <T> T execute(HttpClientRequest request, Class<T> responseClass);

}
