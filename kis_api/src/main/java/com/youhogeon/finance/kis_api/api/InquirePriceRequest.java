package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.URL;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Method;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;

@URL(method = Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-price")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class InquirePriceRequest implements Api<InquirePriceResponse> {

    @Header("content-type")
    private String contentType = "application/json; charset=utf-8";

    @Header("personalseckey")
    private String personalSecKey;

    @Header("tr_id")
    private String trId = "FHKST01010100";

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

    @Parameter("FID_COND_MRKT_DIV_CODE")
    private String marketCode = "UN";

    @Parameter("FID_INPUT_ISCD")
    @NonNull
    private String code;

}
