package com.youhogeon.finance.kis_api.util;

import java.util.HashMap;
import java.util.Map;

import lombok.Setter;

public class MaskingHashMap<K, V> extends HashMap<K, V> {

    private Map<K, Object> maskedMap = new HashMap<>();

    @Setter
    private String maskString = "?";

    public V put(K key, V value) {
        maskedMap.put(key, value);

        return super.put(key, value);
    }

    public V putWithMasking(K key, V value) {
        maskedMap.put(key, maskString);

        return super.put(key, value);
    }

    public void mask(K key) {
        if (!containsKey(key)) {
            return;
        }

        maskedMap.put(key, maskString);
    }

    public String toString() {
        return maskedMap.toString();
    }

    public static <K, V> MaskingHashMap<K, V> from(Map<K, V> map) {
        MaskingHashMap<K, V> newMap = new MaskingHashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            newMap.put(entry.getKey(), entry.getValue());
        }

        return newMap;
    }

}
