package com.youhogeon.finance.kis_api.client.http;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HttpClientRequest {

    private String method;
    private String url;
    private Map<String, Object> parameters;
    private Map<String, Object> headers;
    private Map<String, Object> body;

    public String getMethod() {
        return method.toUpperCase();
    }

}
