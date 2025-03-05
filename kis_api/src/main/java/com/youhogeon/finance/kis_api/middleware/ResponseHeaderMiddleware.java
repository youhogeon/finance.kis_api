package com.youhogeon.finance.kis_api.middleware;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.youhogeon.finance.kis_api.KisClient;
import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.context.ApiContext;
import com.youhogeon.finance.kis_api.client.http.HttpClientResponse;
import com.youhogeon.finance.kis_api.util.ReflectionUtil;

public class ResponseHeaderMiddleware implements Middleware {

    @Override
    public void before(KisClient client, ApiContext context) {

    }

    @Override
    public void after(KisClient client, ApiContext context) {
        HttpClientResponse response = context.getResponse();
        ApiResult result = context.getApiResult();

        Map<String, List<String>> allHeaders = response.getHeaders();
        Map<String, String> headers = new HashMap<>();

        for (String key : allHeaders.keySet()) {
            List<String> value = allHeaders.get(key);

            if (value.isEmpty() || value.size() > 1) {
                continue;
            }

            headers.put(key, value.get(0));
        }

        Field[] fields = ReflectionUtil.getAllFields(result.getClass());

        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(Header.class);

            if (annotation == null) {
                continue;
            }

            String key = ((Header) annotation).value();

            if (headers.containsKey(key)) {
                try {
                    field.setAccessible(true);
                    field.set(result, headers.get(key));
                } catch (IllegalAccessException e) {
                    continue;
                }
            }
        }

    }
}
