package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.Header;

import lombok.Getter;
import lombok.Setter;

import com.youhogeon.finance.kis_api.api.annotation.Body;

@Getter
@Setter
public abstract class CommonLiveRequest<T extends ApiResult> implements Api<T> {

    public enum TransactionType {
        SUBSCRIBE("1"),
        UNSUBSCRIBE("2");

        private String value;

        TransactionType(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    @Header("custtype")
    private String custType = "P";

    @Header("tr_type")
    private TransactionType trType;

    @Header("content-type")
    private String contentType = "utf-8";

    @Body("tr_id")
    private String trId;

    @Body("tr_key")
    private String trKey;

}
