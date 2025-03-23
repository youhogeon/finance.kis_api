package com.youhogeon.finance.kis_api.api.annotation.auth;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AppTokenRequired {
    public enum Location {
        HEADER,
        BODY,
    }

    String key() default "authorization";
    Location location() default Location.HEADER;

    String prefix() default "Bearer ";

}
