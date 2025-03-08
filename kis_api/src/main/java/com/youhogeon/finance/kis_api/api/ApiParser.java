package com.youhogeon.finance.kis_api.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.LiveApi;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.context.ApiData;
import com.youhogeon.finance.kis_api.exception.InvalidApiSpecException;
import com.youhogeon.finance.kis_api.util.AnnotationUtil;
import com.youhogeon.finance.kis_api.util.Pair;
import com.youhogeon.finance.kis_api.util.ReflectionUtil;

public class ApiParser {

    Api<?> apiRequest;
    Class<?> clazz;
    Field[] fields;

    public ApiParser(Api<?> apiRequest) {
        this.apiRequest = apiRequest;
        this.clazz = apiRequest.getClass();
        this.fields = ReflectionUtil.getAllFields(clazz);
    }

    public ApiData parse() {
        Pair<String, String> url = getUrlPath();

        return ApiData.builder()
            .method(url.getFirst())
            .urlPath(url.getSecond())
            .headers(getHeaders())
            .parameters(getParameters())
            .body(getBody())
            .responseClass(getGenericType(apiRequest))
            .annotations(getAnnotation())
            .build();
    }

    private Pair<String, String> getUrlPath() {
        RestApi restApi = clazz.getAnnotation(RestApi.class);

        if (restApi != null) {
            return Pair.of(restApi.method().name(), restApi.path());
        }

        LiveApi liveApi = clazz.getAnnotation(LiveApi.class);

        if (liveApi != null) {
            return Pair.of("WS", liveApi.path());
        }

        throw new InvalidApiSpecException("Api class must have RestApi or LiveApi annotation");
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

    private Annotation[] getAnnotation() {
        return AnnotationUtil.getAllAnnotations(clazz).toArray(new Annotation[0]);
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
