package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.rest.PageableApiResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString()
public abstract class CommonPageableRestResult<T extends ApiResult> extends PageableApiResult<T> {

    @Header("content-type")
    private String contentType;

    @Header
    private String trId;

    @Header
    private String gtUid;

}
