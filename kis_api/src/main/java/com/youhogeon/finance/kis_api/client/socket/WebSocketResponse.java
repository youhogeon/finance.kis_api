package com.youhogeon.finance.kis_api.client.socket;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.youhogeon.finance.kis_api.client.NetworkResponse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class WebSocketResponse implements NetworkResponse {

    private Map<String, String> headers;

    @Getter
    @Setter
    private String body;

    public Map<String, List<String>> getHeaders() {
        return headers.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> List.of(entry.getValue())
            ));
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().get(0)
            ));
    }

    protected String getHeader(String key) {
        return headers.get(key);
    }

}