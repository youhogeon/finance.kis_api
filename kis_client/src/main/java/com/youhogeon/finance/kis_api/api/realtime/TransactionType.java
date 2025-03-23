package com.youhogeon.finance.kis_api.api.realtime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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
