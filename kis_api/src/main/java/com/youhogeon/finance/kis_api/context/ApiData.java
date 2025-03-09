package com.youhogeon.finance.kis_api.context;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.util.AnnotationUtil;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class ApiData {

    private Map<String, Object> body;

    private Map<String, Object> headers;

    private Map<String, Object> parameters;

    @NonNull
    private String method;

    @NonNull
    private String urlPath;

    @NonNull
    private Class<? extends ApiResult> responseClass;

    @Builder.Default
    private Annotation[] annotations = new Annotation[0];

    public boolean hasAnnotation(Class<? extends Annotation> annotationClass) {
        return AnnotationUtil.contains(annotations, annotationClass);
    }

}
