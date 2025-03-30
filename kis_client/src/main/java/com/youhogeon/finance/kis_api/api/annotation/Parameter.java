package com.youhogeon.finance.kis_api.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * API 요청의 URL Parameter를 나타냄.
 *
 * <p>기본값</p>
 * 필드의 이름을 UPPER_SNAKE_CASE로 변환한 값.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Parameter {
    String value() default "";
}
