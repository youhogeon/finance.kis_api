package com.youhogeon.finance.kis_api.client.http;

import java.util.Map;

import com.youhogeon.finance.kis_api.context.ApiData;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HttpClientRequest {

    private String method;
    private String url;
    private Map<String, Object> parameters;
    private Map<String, Object> headers;
    private Map<String, Object> body;

    public String getMethod() {
        return method.toUpperCase();
    }

    public static HttpClientRequest from(String apiHost, ApiData apiData) {
        String urlPath = apiData.getUrlPath();

        if (apiHost.endsWith("/") && urlPath.startsWith("/")) {
            urlPath = urlPath.substring(1);
        } else if (!apiHost.endsWith("/") && !urlPath.startsWith("/")) {
            urlPath = "/" + urlPath;
        }

        return HttpClientRequest.builder()
            .method(apiData.getMethod())
            .url(apiHost + urlPath)
            .parameters(apiData.getParameters())
            .headers(apiData.getHeaders())
            .body(apiData.getBody())
            .build();
    }

}
