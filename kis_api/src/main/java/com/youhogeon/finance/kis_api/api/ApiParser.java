package com.youhogeon.finance.kis_api.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

import com.youhogeon.finance.kis_api.api.annotation.BodyCredentialsRequired;
import com.youhogeon.finance.kis_api.api.annotation.HeaderCredentialsRequired;
import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.URL;
import com.youhogeon.finance.kis_api.context.ApiData;
import com.youhogeon.finance.kis_api.exception.InvalidApiSpecException;
import com.youhogeon.finance.kis_api.util.ReflectionUtil;

public class ApiParser {

    Api<?> apiRequest;
    Class<?> clazz;
    Field[] fields;
    URL url;

    public ApiParser(Api<?> apiRequest) {
        this.apiRequest = apiRequest;
        this.clazz = apiRequest.getClass();
        this.fields = ReflectionUtil.getAllFields(clazz);

        this.url = clazz.getAnnotation(URL.class);

        if (this.url == null) {
            throw new InvalidApiSpecException("URL annotation is required");
        }
    }

    public ApiData parse() {
        return ApiData.builder()
            .method(getMethod())
            .urlPath(getUrlPath())
            .headers(getHeaders())
            .parameters(getParameters())
            .body(getBody())
            .headerCredentialsRequired(isHeaderCredentialsRequired())
            .bodyCredentialsRequired(isBodyCredentialsRequired())
            .responseClass(getGenericType(apiRequest))
            .build();
    }

    private String getUrlPath() {
        return url.path();
    }

    private String getMethod() {
        return url.method().name();
    }

    private LinkedHashMap<String, Object> getHeaders() {
        return getFieldsByAnnotation(Header.class);
    }

    private LinkedHashMap<String, Object> getParameters() {
        return getFieldsByAnnotation(Parameter.class);
    }

    private LinkedHashMap<String, Object> getBody() {
        return getFieldsByAnnotation(Body.class);
    }

    private boolean isHeaderCredentialsRequired() {
        return clazz.isAnnotationPresent(HeaderCredentialsRequired.class);
    }

    private boolean isBodyCredentialsRequired() {
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

    @SuppressWarnings("unchecked")
    private <T extends ApiResult> Class<T> getGenericType(Api<T> api) {
        Type generic = api.getClass().getGenericSuperclass();

        if (generic == null || generic == Object.class) {
            Type[] genericInterfaces = api.getClass().getGenericInterfaces();

            if (genericInterfaces.length == 0) {
                return null;
            }

            generic = genericInterfaces[0];
        }

        ParameterizedType parameterizedType = (ParameterizedType) generic;


        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

}
