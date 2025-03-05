package com.youhogeon.finance.kis_api.util;

import java.util.HashMap;
import java.util.Map;

public class MaskingHashMap<K, V> extends HashMap<K, V> {
    
    private Map<K, Object> maskedMap = new HashMap<>();

    public V put(K key, V value) {
        maskedMap.put(key, value);

        return super.put(key, value);
    }

    public V putWithMasking(K key, V value) {
        maskedMap.put(key, "***");

        return super.put(key, value);
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
