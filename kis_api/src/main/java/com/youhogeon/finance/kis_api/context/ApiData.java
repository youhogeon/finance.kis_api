package com.youhogeon.finance.kis_api.context;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.util.ReflectionUtil;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class ApiData {

    @NonNull
    private String method;

    @NonNull
    private String urlPath;

    @NonNull
    private Map<String, Object> body;

    @NonNull
    private Map<String, Object> headers;

    @NonNull
    private Map<String, Object> parameters;

    @NonNull
    private Class<? extends ApiResult> responseClass;

    @Builder.Default
    private Annotation[] annotations = new Annotation[0];

    public  boolean hasAnnotation(Class<? extends Annotation> annotationClass) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(annotationClass)) {
                return true;
            }
        }

        return false;
    }

    public  boolean hasAnnotation(Class<? extends Annotation> annotationClass, Object... expectedValues) {
        for (Annotation annotation : annotations) {
            if (ReflectionUtil.compareAnnotation(annotation, annotationClass, expectedValues)) {
                return true;
            }
        }

        return false;
    }

}
