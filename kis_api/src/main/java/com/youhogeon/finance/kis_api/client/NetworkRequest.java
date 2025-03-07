package com.youhogeon.finance.kis_api.client;

import java.util.Map;

public interface NetworkRequest {

    public Map<String, Object> getHeaders();
    public void setHeaders(Map<String, Object> headers);

    public Map<String, Object> getBody();
    public void setBody(Map<String, Object> body);

}
