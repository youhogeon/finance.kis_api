package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppKeyRequired;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppSecretRequired;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppTokenRequired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AppKeyRequired(location = AppKeyRequired.Location.HEADER)
@AppSecretRequired(location = AppSecretRequired.Location.HEADER)
@AppTokenRequired(location = AppTokenRequired.Location.HEADER)
public abstract class CommonRestApi<T extends ApiResult> implements Api<T> {

    @Header("content-type")
    private String contentType = "application/json; charset=utf-8";

    @Header
    private String personalseckey;

    @Header
    private String trCont;

    @Header
    private String custtype = "P";

    @Header
    private String seqNo;

    @Header
    private String macAddress;

    @Header
    private String phoneNumber;

    @Header
    private String ipAddr;

    @Header
    private String gtUid;

}
