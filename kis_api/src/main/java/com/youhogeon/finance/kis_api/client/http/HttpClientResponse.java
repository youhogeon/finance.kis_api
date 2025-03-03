package com.youhogeon.finance.kis_api.client.http;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HttpClientResponse {

    private int statusCode;
    private Map<String, List<String>> headers;
    private String body;

}