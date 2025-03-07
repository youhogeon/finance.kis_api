package com.youhogeon.finance.kis_api.client;

import java.util.List;
import java.util.Map;

public interface NetworkResponse {

    public Map<String, List<String>> getHeaders();
    public void setHeaders(Map<String, List<String>> headers);

    public String getBody();
    public void setBody(String body);

}
