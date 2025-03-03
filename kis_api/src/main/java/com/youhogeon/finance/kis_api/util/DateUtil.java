package com.youhogeon.finance.kis_api.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

    private static final DateTimeFormatter[] DT_FORMATTERS = new DateTimeFormatter[]{
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
        DateTimeFormatter.ofPattern("yyyyMMdd HHmmss"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("yyyyMMdd"),
    };

    private static final DateTimeFormatter[] D_FORMATTERS = new DateTimeFormatter[]{
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("yyyyMMdd"),
    };

    private static final DateTimeFormatter FORMATTER_YYYYMMDD = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter FORMATTER_HHMMSS = DateTimeFormatter.ofPattern("HHmmss");

    public static LocalDateTime toLocalDateTime(String data) {

        try {
            return LocalDateTime.parse(data);
        } catch (DateTimeParseException e) {

        }

        for (DateTimeFormatter formatter : DT_FORMATTERS) {
            try {
                return LocalDateTime.parse(data, formatter);
            } catch (DateTimeParseException e) {

            }
        }

        throw new DateTimeParseException("날짜/시간 형식 문자열 파싱 실패", data, 0);
    }

    public static LocalDate toLocalDate(String data) {

        try {
            return LocalDate.parse(data);
        } catch (DateTimeParseException e) {

        }

        for (DateTimeFormatter formatter : D_FORMATTERS) {
            try {
                return LocalDate.parse(data, formatter);
            } catch (DateTimeParseException e) {

            }
        }

        throw new DateTimeParseException("날짜 형식 문자열 파싱 실패", data, 0);
    }

    public static String toYYYYMMDD(LocalDate data) {
        return data.format(FORMATTER_YYYYMMDD);
    }

    public static String toYYYYMMDD(LocalDateTime data) {
        return data.format(FORMATTER_YYYYMMDD);
    }

    public static String toHHMMSS(LocalDateTime data) {
        return data.format(FORMATTER_HHMMSS);
    }

    public static String toHHMMSS(LocalTime data) {
        return data.format(FORMATTER_HHMMSS);
    }

}