package com.youhogeon.finance.kis_api.context;

import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;

import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.util.AnnotationUtil;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class ApiData implements Cloneable {

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

    public ApiData clone() {
        try {
            ApiData cloned = (ApiData) super.clone();

            cloned.body = new LinkedHashMap<>(body);
            cloned.headers = new LinkedHashMap<>(headers);
            cloned.parameters = new LinkedHashMap<>(parameters);

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Failed to clone ApiData", e);
        }

    }

}
