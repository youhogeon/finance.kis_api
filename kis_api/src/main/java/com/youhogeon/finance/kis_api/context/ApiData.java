package com.youhogeon.finance.kis_api.context;

import java.util.Map;

import com.youhogeon.finance.kis_api.api.ApiResult;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class ApiData {

    @NonNull
    private String method;

    @NonNull
    private String urlPath;

    @NonNull
    private Map<String, Object> body;

    @NonNull
    private Map<String, Object> headers;

    @NonNull
    private Map<String, Object> parameters;

    private boolean bodyCredentialsRequired;
    private boolean headerCredentialsRequired;

    private Class<? extends ApiResult> responseClass;

}
