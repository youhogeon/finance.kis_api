package com.youhogeon.finance.kis_api.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StringUtil {

    public static String makeUrlParamString(Object object) {
        if (object == null) {
            return "";
        }

        if (object instanceof Map<?, ?> map) {
            return map.entrySet().stream()
            .map(entry -> {
                String key = URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8);
                String value = URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8);
                return key + "=" + value;
            })
            .collect(Collectors.joining("&"));
        }

        Arrays.stream(object.getClass().getDeclaredFields());

        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter(field -> {
                    try {
                        field.setAccessible(true);
                        return field.get(object) != null;
                    } catch (IllegalAccessException e) {
                        return false;
                    }
                })
                .map(field -> {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(object);

                        // @JsonProperty 어노테이션이 있는 경우 해당 값 사용.
                        JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);
                        String key = (jsonProperty != null) ? jsonProperty.value() : field.getName();

                        return URLEncoder.encode(key, StandardCharsets.UTF_8) + "="
                                + URLEncoder.encode(String.valueOf(value), StandardCharsets.UTF_8);
                    } catch (IllegalAccessException e) {
                        return null;
                    }
                }).filter(param -> param != null)
                .collect(Collectors.joining("&"));
    }

    public static String concatUrl(String url, String path) {
        if (url.endsWith("/") && path.startsWith("/")) {
            return url + path.substring(1);
        } else if (!url.endsWith("/") && !path.startsWith("/")) {
            return url + "/" + path;
        } else {
            return url + path;
        }
    }

    public static String decryptAes256(String data, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            byte[] decodedData = Base64.getDecoder().decode(data);
            byte[] decrypted = cipher.doFinal(decodedData);

            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    public static String[] fastSplit(String str, char delimiter) {
        int count = 0;
        int pos = 0;

        while (true) {
            int index = str.indexOf(delimiter, pos);
            if (index == -1) break;

            count++;
            pos = index + 1;
        }

        String[] result = new String[count + 1];
        pos = 0;
        int i = 0;

        while (true) {
            int index = str.indexOf(delimiter, pos);
            if (index == -1) break;

            result[i++] = str.substring(pos, index);
            pos = index + 1;
        }
        result[i] = str.substring(pos);
        return result;
    }

    public static String toSnakeCase(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '_') {
                sb.append(c);
            } else if (Character.isUpperCase(c)) {
                if (i > 0 && input.charAt(i - 1) != '_' && Character.isLowerCase(input.charAt(i - 1))) {
                    sb.append('_');
                }

                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String toUpperSnakeCase(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '_') {
                sb.append(c);
            } else if (Character.isUpperCase(c)) {
                if (i > 0 && input.charAt(i - 1) != '_' && Character.isLowerCase(input.charAt(i - 1))) {
                    sb.append('_');
                }

                sb.append(c);
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }

        return sb.toString();
    }

}
