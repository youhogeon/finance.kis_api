package com.youhogeon.finance.kis_api.client.http;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.config.Configuration;
import com.youhogeon.finance.kis_api.context.ApiContext;
import com.youhogeon.finance.kis_api.context.ApiData;
import com.youhogeon.finance.kis_api.util.CredentialsUtil;
import com.youhogeon.finance.kis_api.util.JsonUtil;
import com.youhogeon.finance.kis_api.util.ReflectionUtil;
import com.youhogeon.finance.kis_api.util.StringUtil;
import com.youhogeon.finance.kis_api.exception.InvalidApiRequestException;

public class JavaHttpClient extends com.youhogeon.finance.kis_api.client.http.HttpClient {

    HttpClient client;
    Configuration config;

    private static final Logger logger = LoggerFactory.getLogger(JavaHttpClient.class);

    public JavaHttpClient(Configuration config) {
        Duration timeout = config.getHttpTimeout();

        this.config = config;
        this.client = HttpClient
            .newBuilder()
            .connectTimeout(timeout)
            .build();
    }

    @Override
    public HttpClientRequest makeRequest(ApiData apiData) {
        String apiHost = config.getHttpHost();
        String urlPath = apiData.getUrlPath();
        String url = StringUtil.concatUrl(apiHost, urlPath);

        return HttpClientRequest.builder()
            .method(apiData.getMethod())
            .url(url)
            .parameters(apiData.getParameters())
            .headers(apiData.getHeaders())
            .body(apiData.getBody())
            .build();
    }

    @Override
    public void execute(ApiContext context) throws IOException {
        HttpClientRequest request = (HttpClientRequest)context.getRequest();
        ApiData api = context.getApiData();

        HttpResponse<String> response = null;

        try {
            if (request.getMethod() == "POST") {
                response = POST(request);
            } else {
                response = GET(request);
            }
        } catch (IOException e) {
            throw e;
        } catch (InterruptedException e) {
            throw new IOException("Failed to get response from server. (InterruptedException)");
        }

        if (response == null) {
            throw new IOException("Failed to get response from server.");
        }

        String responseString = response.body();
        int statusCode = response.statusCode();
        Map<String, List<String>> headers = response.headers().map();

        if (logger.isDebugEnabled()) {
            String maskedResponseString = config.isMaskCredentials() ? CredentialsUtil.maskAccessToken(responseString) : responseString;

            logger.debug("API Request ends. [{}] {} -> ({}) {}", api.getClass().getSimpleName(), request, statusCode, maskedResponseString);
        }

        if (responseString == null) {
            throw new InvalidApiRequestException("Failed to get response from server. (no response)", statusCode);
        }

        if (statusCode != 200) {
            logger.error("API Response Error [{}] : Unexpected status code {}. {} -> {}", api.getClass().getSimpleName(), statusCode, request, responseString);

            throw new InvalidApiRequestException(responseString, statusCode);
        }

        HttpClientResponse clinetResponse = HttpClientResponse.builder()
            .statusCode(statusCode)
            .headers(headers)
            .body(responseString)
            .build();

        ApiResult apiResult = makeApiResult(clinetResponse, context.getApiData());

        context.setResponse(clinetResponse);
        context.setApiResult(apiResult);
    }

    private ApiResult makeApiResult(HttpClientResponse clinetResponse, ApiData apiData) {
        String responseString = clinetResponse.getBody();

        ApiResult result = JsonUtil.fromJson(responseString, apiData.getResponseClass());

        injectHeader(clinetResponse, result);

        return result;
    }

    private void injectHeader(HttpClientResponse clientResponse, ApiResult result) {
        Map<String, List<String>> allHeaders = clientResponse.getHeaders();
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

    @Override
    public void close() throws IOException {
        if (client == null) {
            return;
        }

        client.close();
    }

    public HttpRequest.Builder getRequestBuilder(HttpClientRequest request) {
        String parameter = StringUtil.makeUrlParamString(request.getParameters());
        String fullUrl = request.getUrl() + "?" + parameter;

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
            .uri(URI.create(fullUrl));

        for (Map.Entry<String, Object> entry : request.getHeaders().entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }

            requestBuilder = requestBuilder.header(entry.getKey(), entry.getValue().toString());
        }

        return requestBuilder;
    }

    public HttpResponse<String> GET(HttpClientRequest request) throws IOException, InterruptedException {
        HttpRequest req = getRequestBuilder(request).GET().build();

        HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    public HttpResponse<String> POST(HttpClientRequest request) throws IOException, InterruptedException {
        String jsonBody = JsonUtil.toJson(request.getBody());

        HttpRequest req = getRequestBuilder(request)
                            .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                            .build();

        HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());

        return response;
    }
}
