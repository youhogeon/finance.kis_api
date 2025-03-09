package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppKeyRequired;
import com.youhogeon.finance.kis_api.api.annotation.auth.AppSecretRequired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AppKeyRequired(location = AppKeyRequired.Location.HEADER)
@AppSecretRequired(location = AppSecretRequired.Location.HEADER)
public abstract class CommonRestApi<T extends ApiResult> implements Api<T> {

    @Header("content-type")
    private String contentType = "application/json; charset=utf-8";

    @Header("personalseckey")
    private String personalSecKey;

    @Header("tr_cont")
    private String trCont;

    @Header("custtype")
    private String custType = "P";

    @Header("seq_no")
    private String seqNo;

    @Header("mac_address")
    private String macAddress;

    @Header("phone_number")
    private String phoneNumber;

    @Header("ip_addr")
    private String ipAddr;

    @Header("gt_uid")
    private String gtUid;

}
