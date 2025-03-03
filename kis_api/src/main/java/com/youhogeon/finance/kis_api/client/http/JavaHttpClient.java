package com.youhogeon.finance.kis_api.client.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import com.youhogeon.finance.kis_api.api.ErrorResponse;
import com.youhogeon.finance.kis_api.exception.InvalidApiRequestException;
import com.youhogeon.finance.kis_api.util.JsonConverter;
import com.youhogeon.finance.kis_api.util.UrlParameterConverter;

public class JavaHttpClient implements com.youhogeon.finance.kis_api.client.http.HttpClient {

    HttpClient client;
    String host;

    public JavaHttpClient(String host) {
        this(host, Duration.ofSeconds(10));
    }

    public JavaHttpClient(String host, Duration timeout) {
        this.host = host;
        this.client = HttpClient
                    .newBuilder()
                    .connectTimeout(timeout)
                    .build();
    }

    @Override
    public HttpClientResponse execute(HttpClientRequest request) throws IOException {
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

        return HttpClientResponse.builder()
            .statusCode(statusCode)
            .headers(headers)
            .body(responseString)
            .build();
    }

    public HttpRequest.Builder getRequestBuilder(HttpClientRequest request) {
        String parameter = UrlParameterConverter.toUrlParams(request.getParameters());
        String fullUrl = this.host + request.getUrl() + "?" + parameter;

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
        String jsonBody = JsonConverter.toJson(request.getBody());

        HttpRequest req = getRequestBuilder(request)
                            .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                            .build();

        HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());

        return response;
    }

}
