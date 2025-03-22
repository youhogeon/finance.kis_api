package com.youhogeon.finance.kis_api.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;

import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RealTimeApi;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.context.ApiData;
import com.youhogeon.finance.kis_api.exception.InvalidApiSpecException;
import com.youhogeon.finance.kis_api.util.AnnotationUtil;
import com.youhogeon.finance.kis_api.util.Pair;
import com.youhogeon.finance.kis_api.util.ReflectionUtil;

public class ApiParser {

    private Api<?> apiRequest;
    private Class<?> clazz;

    // private Map<String, ApiData> cache = new HashMap<>();

    public ApiParser(Api<?> apiRequest) {
        this.apiRequest = apiRequest;
        this.clazz = apiRequest.getClass();
    }

    public ApiData parse() {
        Pair<String, String> url = getUrlPath();

        return ApiData.builder()
            .method(url.getFirst())
            .urlPath(url.getSecond())
            .responseClass(getGenericType(apiRequest))
            .annotations(getAnnotation())
            .headers(getHeaders())
            .parameters(getParameters())
            .body(getBody())
            .build();
    }

    private Pair<String, String> getUrlPath() {
        RestApi restApi = clazz.getAnnotation(RestApi.class);

        if (restApi != null) {
            return Pair.of(restApi.method().name(), restApi.path());
        }

        RealTimeApi realTimeApi = clazz.getAnnotation(RealTimeApi.class);

        if (realTimeApi != null) {
            return Pair.of("WS", realTimeApi.path());
        }

        throw new InvalidApiSpecException("Api class must have RestApi or RealTimeApi annotation");
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
        LinkedHashMap<String, Object> values = new LinkedHashMap<>();
        Field[] fields = ReflectionUtil.getAllFields(clazz);

        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(annotationClass);

            if (annotation == null) {
                continue;
            }

            String key = field.getName();

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

                Object value = field.get(apiRequest);

                values.put(key, value);
            } catch (IllegalAccessException e) {
                throw new InvalidApiSpecException("Failed to access field: " + field.getName());
            }
        }

        return values;
    }

    private <T extends ApiResult> Class<T> getGenericType(Api<T> api) {
        return ReflectionUtil.getGenericParameterType(api);
    }

}
