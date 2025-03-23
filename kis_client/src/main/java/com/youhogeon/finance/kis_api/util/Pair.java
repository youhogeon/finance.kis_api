package com.youhogeon.finance.kis_api.util;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Pair<T1, T2> {

    private final T1 a;
    private final T2 b;

    public Pair(T1 a, T2 b) {
        this.a = a;
        this.b = b;
    }

    public T1 getFirst() {
        return a;
    }

    public T2 getSecond() {
        return b;
    }

    public static <T1, T2> Pair<T1, T2> of(T1 a, T2 b) {
        return new Pair<>(a, b);
    }

}