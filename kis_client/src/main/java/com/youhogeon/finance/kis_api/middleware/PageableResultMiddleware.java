package com.youhogeon.finance.kis_api.middleware;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.youhogeon.finance.kis_api.KisClient;
import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.api.rest.PageableApiResult;
import com.youhogeon.finance.kis_api.config.Credentials;
import com.youhogeon.finance.kis_api.context.ApiContext;
import com.youhogeon.finance.kis_api.context.ApiData;
import com.youhogeon.finance.kis_api.util.Pair;
import com.youhogeon.finance.kis_api.util.ReflectionUtil;

public class PageableResultMiddleware implements Middleware {

    @Override
    public void afterInit(KisClient client, ApiContext context) {
    }

    @Override
    public void before(KisClient client, ApiContext context) {
    }

    @Override
    public void after(KisClient client, ApiContext context) {
        ApiResult result = context.getApiResult();

        if (!(result instanceof PageableApiResult)) {
            return;
        }

        ApiData apiData = context.getApiData();
        Credentials credentials = context.getCredentials();

        try {
            Field nextFunctionField = ReflectionUtil.getFieldFromClassHierarchy(result.getClass(), "nextFunction");

            nextFunctionField.set(result, new Supplier<>() {
                @Override
                public ApiResult get() {
                    ApiData clonedApiData = apiData.clone();

                    List<Pair<String, String>> values = List.of(
                        new Pair<>("tr_cont", "N"),
                        new Pair<>("CTX_AREA_FK100", ((PageableApiResult<?>) result).getCtxAreaFk100()),
                        new Pair<>("CTX_AREA_NK100", ((PageableApiResult<?>) result).getCtxAreaNk100()),
                        new Pair<>("CTX_AREA_FK200", ((PageableApiResult<?>) result).getCtxAreaFk200()),
                        new Pair<>("CTX_AREA_NK200", ((PageableApiResult<?>) result).getCtxAreaNk200())
                    );

                    List<Map<String, Object>> maps = List.of(
                        clonedApiData.getHeaders(),
                        clonedApiData.getBody(),
                        clonedApiData.getParameters()
                    );

                    for (Pair<String, String> entry : values) {
                        if (entry.getSecond() == null || entry.getSecond().isEmpty()) {
                            continue;
                        }

                        for (Map<String, Object> map : maps) {
                            if (map.containsKey(entry.getFirst())) {
                                map.put(entry.getFirst(), entry.getSecond());
                            }
                        }
                    }

                    return client.execute(clonedApiData, credentials);
                }
            });
        } catch (NoSuchFieldException | IllegalAccessException e) {

        }
    }

}
