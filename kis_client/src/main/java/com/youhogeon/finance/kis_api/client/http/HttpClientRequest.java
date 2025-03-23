package com.youhogeon.finance.kis_api.client.http;

import java.util.Map;

import com.youhogeon.finance.kis_api.client.NetworkRequest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HttpClientRequest implements NetworkRequest {

    private String method;
    private String url;
    private Map<String, Object> parameters;
    private Map<String, Object> headers;
    private Map<String, Object> body;

    public String getMethod() {
        return method.toUpperCase();
    }

}
