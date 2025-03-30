package com.youhogeon.finance.kis_api.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
import com.youhogeon.finance.kis_api.util.StringUtil;

/**
 * @hidden
 */
public class ApiParser {

    private Api<?> apiRequest;
    private Class<?> clazz;

    private static Map<Class<?>, Pair<String, String>> urlPathCache = new HashMap<>();
    private static Map<Class<?>, HashMap<Class<? extends Annotation>, LinkedHashMap<String, Field>>> fieldCache = new HashMap<>();

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

    private HashMap<Class<? extends Annotation>, LinkedHashMap<String, Field>> inspectFields() {
        if (fieldCache.containsKey(clazz)) {
            return fieldCache.get(clazz);
        }

        Field[] fields = ReflectionUtil.getAllFields(clazz);

        HashMap<Class<? extends Annotation>, LinkedHashMap<String, Field>> result = new HashMap<>();

        LinkedHashMap<String, Field> headers = new LinkedHashMap<>();
        LinkedHashMap<String, Field> parameters = new LinkedHashMap<>();
        LinkedHashMap<String, Field> body = new LinkedHashMap<>();

        for (Field field : fields) {
            Annotation[] annotation = field.getAnnotations();

            for (Annotation a : annotation) {
                if (a instanceof Header) {
                    String key = ((Header) a).value();
                    headers.put(key.equals("") ? StringUtil.toSnakeCase(field.getName()) : key, field);
                } else if (a instanceof Parameter) {
                    String key = ((Parameter) a).value();
                    parameters.put(key.equals("") ? StringUtil.toUpperSnakeCase(field.getName()) : key, field);
                } else if (a instanceof Body) {
                    String key = ((Body) a).value();
                    body.put(key.equals("") ? StringUtil.toUpperSnakeCase(field.getName()) : key, field);
                } else {
                    continue;
                }
            }
        }

        result.put(Header.class, headers);
        result.put(Parameter.class, parameters);
        result.put(Body.class, body);

        fieldCache.put(clazz, result);

        return result;
    }

    private Pair<String, String> getUrlPath() {
        if (urlPathCache.containsKey(clazz)) {
            return urlPathCache.get(clazz);
        }

        RestApi restApi = clazz.getAnnotation(RestApi.class);

        if (restApi != null) {
            Pair<String, String> urlPath = Pair.of(restApi.method().name(), restApi.path());
            urlPathCache.put(clazz, urlPath);

            return urlPath;
        }

        RealTimeApi realTimeApi = clazz.getAnnotation(RealTimeApi.class);

        if (realTimeApi != null) {
            Pair<String, String> urlPath = Pair.of("WS", realTimeApi.path());
            urlPathCache.put(clazz, urlPath);

            return urlPath;
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
        HashMap<Class<? extends Annotation>, LinkedHashMap<String, Field>> allFields = inspectFields();
        LinkedHashMap<String, Field> fields = allFields.get(annotationClass);

        LinkedHashMap<String, Object> values = new LinkedHashMap<>();

        try {
            for (Map.Entry<String, Field> item : fields.entrySet()) {
                Field field = item.getValue();
                field.setAccessible(true);

                values.put(item.getKey(), field.get(apiRequest));
            }
        } catch (IllegalAccessException e) {
            throw new InvalidApiSpecException("Failed to access Api class field");
        }

        return values;
    }

    private <T extends ApiResult> Class<T> getGenericType(Api<T> api) {
        return ReflectionUtil.getGenericParameterType(api);
    }

}
