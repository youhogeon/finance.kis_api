package com.youhogeon.finance.kis_api.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * API 요청/응답의 Header를 나타냄.
 *
 * <p>기본값</p>
 * 필드의 이름을 snake_case로 변환한 값.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Header {
    String value() default "";
}
