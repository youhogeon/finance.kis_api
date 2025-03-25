package com.youhogeon.finance.kis_api.api.annotation.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AccountRequired {
    public enum Location {
        HEADER,
        PARAMETER,
        BODY,
    }

    String key1() default "CANO";
    String key2() default "ACNT_PRDT_CD";

    Location location() default Location.BODY;
}
