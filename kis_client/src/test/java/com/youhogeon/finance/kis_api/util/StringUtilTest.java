package com.youhogeon.finance.kis_api.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    public void fastSplitTest() {
        String data = "000100^121829^121100^2^2200^1.85^120148.58^119200^121800^117800^121200^121100^12^364979^43851673350^4661^5875^1214^103.33^174543^180348^5^0.50^29.09^090008^2^1900^110406^5^-700^090503^2^3300^20250310^20^N^775^1002^15679^6202^0.46^885992^41.19^0^^11920";

        String[] result = StringUtil.fastSplit(data, '^');
        String[] expected = data.split("\\^");

        assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void toSnakeCaseTest() {
        assertEquals(StringUtil.toSnakeCase("camelCase"), "camel_case");
        assertEquals(StringUtil.toSnakeCase("snake_case"), "snake_case");
        assertEquals(StringUtil.toSnakeCase("SNAKE_CASE"), "snake_case");
        assertEquals(StringUtil.toSnakeCase("ABCDE"), "abcde");
    }

    @Test
    public void toUpperSnakeCaseTest() {
        assertEquals(StringUtil.toUpperSnakeCase("camelCase"), "CAMEL_CASE");
        assertEquals(StringUtil.toUpperSnakeCase("snake_case"), "SNAKE_CASE");
        assertEquals(StringUtil.toUpperSnakeCase("SNAKE_CASE"), "SNAKE_CASE");
        assertEquals(StringUtil.toUpperSnakeCase("ABCDE"), "ABCDE");
    }

}
