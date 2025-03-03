package com.youhogeon.finance.kis_api.client;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;

import com.youhogeon.finance.kis_api.api.Api;
import com.youhogeon.finance.kis_api.api.annotation.BodyCredentialsRequired;
import com.youhogeon.finance.kis_api.api.annotation.NoCredentialsRequired;
import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.URL;
import com.youhogeon.finance.kis_api.exception.InvalidApiSpecException;

public class ApiParser {

    Api<?> apiRequest;
    Class<?> clazz;
    Field[] fields;
    URL url;

    public ApiParser(Api<?> apiRequest) {
        this.apiRequest = apiRequest;
        this.clazz = apiRequest.getClass();
        this.fields = clazz.getDeclaredFields();

        this.url = clazz.getAnnotation(URL.class);

        if (this.url == null) {
            throw new InvalidApiSpecException("URL annotation is required");
        }
    }

    public String getUrlPath() {
        return url.path();
    }

    public String getMethod() {
        return url.method().name();
    }

    public LinkedHashMap<String, Object> getHeaders() {
        return getFieldsByAnnotation(Header.class);
    }

    public LinkedHashMap<String, Object> getParameters() {
        return getFieldsByAnnotation(Parameter.class);
    }

    public LinkedHashMap<String, Object> getBody() {
        return getFieldsByAnnotation(Body.class);
    }

    public boolean isNoCredentialsRequired() {
        return clazz.isAnnotationPresent(NoCredentialsRequired.class);
    }

    public boolean isBodyCredentialsRequired() {
        return clazz.isAnnotationPresent(BodyCredentialsRequired.class);
    }

    private LinkedHashMap<String, Object> getFieldsByAnnotation(Class<? extends Annotation> annotationClass) {
        LinkedHashMap<String, Object> headers = new LinkedHashMap<>();

        for (Field field : this.fields) {
            Annotation annotation = field.getAnnotation(annotationClass);

            if (annotation == null) {
                continue;
            }

            String key = null;

            if (annotation instanceof Header) {
                key = ((Header) annotation).value();
            } else if (annotation instanceof Parameter) {
                key = ((Parameter) annotation).value();
            } else if (annotation instanceof Body) {
                key = ((Body) annotation).value();
            } else {
                continue;
            }

            try {
                field.setAccessible(true);

                Object headerValue = field.get(apiRequest);

                headers.put(key, headerValue);
            } catch (IllegalAccessException e) {
                throw new InvalidApiSpecException("Failed to access field: " + field.getName());
            }
        }

        return headers;
    }

}
