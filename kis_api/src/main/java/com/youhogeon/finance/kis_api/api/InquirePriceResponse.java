package com.youhogeon.finance.kis_api.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InquirePriceResponse implements ApiResponse {

    @JsonProperty("msg1")
    private String msg1;

    @JsonProperty("msg_cd")
    private String msgCode;

}
