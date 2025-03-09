package com.youhogeon.finance.kis_api.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.auth.ApprovalKeyRequired;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@ApprovalKeyRequired(location = ApprovalKeyRequired.Location.HEADER)
public abstract class CommonRealTimeApi<T extends ApiResult> implements Api<T> {

    public enum TransactionType {
        SUBSCRIBE("1"),
        UNSUBSCRIBE("2");

        private String value;

        TransactionType(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @JsonCreator
        public static TransactionType forValue(String value) {
            for (TransactionType t : TransactionType.values()) {
                if (t.value.equals(value)) {
                    return t;
                }
            }

            throw new IllegalArgumentException("Unknown value: " + value);
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public CommonRealTimeApi(String trId, String trKey) {
        this.trId = trId;
        this.trKey = trKey;
    }

    @Header("custtype")
    private String custType = "P";

    @Header("tr_type")
    private TransactionType trType = TransactionType.SUBSCRIBE;

    @Header("content-type")
    private String contentType = "utf-8";

    @NonNull
    @Body("tr_id")
    private String trId;

    @NonNull
    @Body("tr_key")
    private String trKey;

}
