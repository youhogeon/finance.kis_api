package com.youhogeon.finance.kis_api.util;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class MaskingHashMapTest {

    private static final String MASK = "***";

    @Test
    void intTest() {
        MaskingHashMap<String, Integer> map = new MaskingHashMap<>();
        map.setMaskString(MASK);

        map.put("A", 123);
        map.putWithMasking("B", 100);

        String result = map.toString();

        assert(result.contains("A=123"));
        assert(result.contains("B=***"));
    }

    @Test
    void stringTest() {
        MaskingHashMap<String, String> map = new MaskingHashMap<>();
        map.setMaskString(MASK);

        map.putWithMasking("A", "hello");
        map.put("B", ",");
        map.putWithMasking("C", "world");
        map.put("D", "!");

        String result = map.toString();

        assert(result.contains("A=***"));
        assert(result.contains("B=,"));
        assert(result.contains("C=***"));
        assert(result.contains("D=!"));
    }

    @Test
    void fromMethodTest() {
        MaskingHashMap<String, String> map = MaskingHashMap.from(Map.of("A", "AA", "B", "BB"));
        map.setMaskString(MASK);

        String result = map.toString();
        assert(result.contains("A=AA"));
        assert(result.contains("B=BB"));

        map.putWithMasking("B", "BBB");
        result = map.toString();
        assert(result.contains("A=AA"));
        assert(result.contains("B=***"));

        map.put("B", "BBBB");
        result = map.toString();
        assert(result.contains("A=AA"));
        assert(result.contains("B=BBBB"));
    }


}
