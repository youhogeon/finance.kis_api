package com.youhogeon.finance.kis_api.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlParameterConverter {

    public static String toUrlParams(Object object) {
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

}
