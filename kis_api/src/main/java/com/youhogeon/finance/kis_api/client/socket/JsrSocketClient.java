package com.youhogeon.finance.kis_api.client.socket;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.config.Configuration;
import com.youhogeon.finance.kis_api.context.ApiContext;
import com.youhogeon.finance.kis_api.context.ApiData;
import com.youhogeon.finance.kis_api.exception.KisClientException;
import com.youhogeon.finance.kis_api.util.JsonConverter;
import com.youhogeon.finance.kis_api.util.Pair;
import com.youhogeon.finance.kis_api.util.StringUtil;

import jakarta.websocket.ClientEndpoint;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;

@ClientEndpoint
public class JsrSocketClient extends SocketClient {

    private final Configuration config;
    private Session session;

    private final ConcurrentHashMap<Pair<String, String>, CompletableFuture<Pair<WebSocketResponse, ApiResult>>> locks = new ConcurrentHashMap<>();

    private final Map<String, Class<? extends ApiResult>> responseClassesByTrId = new HashMap<>();
    private final ConcurrentHashMap<Pair<String, String>, Pair<WebSocketResponse, ApiResult>> cache = new ConcurrentHashMap<>();

    private final WebSocketContainer container = ContainerProvider.getWebSocketContainer();
    private final URI uri;

    private static final Logger logger = LoggerFactory.getLogger(JsrSocketClient.class);

    public JsrSocketClient(Configuration config) {
        this.config = config;
        this.uri = URI.create(config.getSocketHost());
    }

    @Override
    public WebSocketRequest makeRequest(ApiData apiData) {
        String apiHost = config.getHttpHost();
        String urlPath = apiData.getUrlPath();
        String url = StringUtil.concatUrl(apiHost, urlPath);

        return WebSocketRequest.builder()
            .url(url)
            .headers(apiData.getHeaders())
            .body(apiData.getBody())
            .build();
    }

    @OnOpen
    public void onOpen(Session session) {
        logger.info("Connected to websocket server successfully.");

        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) {
        logger.debug("Data received from WebSocket: {}", message);

        if (isDataResponse(message)) {
            return;
        }

        WebSocketResponse response = parseMessage(message);

        String trId = response.getHeader("tr_id");
        String trKey = response.getHeader("tr_key");

        Pair<String, String> key = Pair.of(trId, trKey);

        Pair<WebSocketResponse, ApiResult> data = Pair.of(response, null);

        // Pair<String, String> key = Pair.of(data.getLeft().getTrId(), data.getLeft().getTrKey());

        CompletableFuture<Pair<WebSocketResponse, ApiResult>> future = locks.remove(key);

        if (future != null) {
            future.complete(data);
        } else {
            logger.warn("대기 중인 future 없음: {}", key);
        }
    }

    private boolean isDataResponse(String message) {
        return message.charAt(0) != '{';
    }

    private WebSocketResponse parseMessage(String message) {
        WebSocketResponse response = JsonConverter.fromJson(message, WebSocketResponse.class);

        System.out.println(response);

        return null;

        // Object headerObj = map.get("header");
        // String trId;
        // String trKey;

        // if (headerObj instanceof Map) {
        //     header = (Map<?, ?>) headerObj;
        // } else {
        //     throw new KisClientException("Invalid response format: " + message);
        // }


        // String trId = map.get("tr_id").toString();
        // String trKey = map.get("tr_key").toString();

        // Class<? extends ApiResult> responseClass = responseClassesByTrId.get(trId);
        // if (responseClass == null) {
        //     throw new KisClientException("Response class not found for trId: " + trId);
        // }
    }

    @Override
    public void execute(ApiContext context) throws IOException {
        ApiData apiData = context.getApiData();
        WebSocketRequest request = (WebSocketRequest) context.getRequest();

        String trId = request.getBody().get("tr_id").toString();
        Pair<String, String> key = Pair.of(trId, request.getBody().get("tr_key").toString());

        Pair<WebSocketResponse, ApiResult> cachedResult = cache.get(key);
        if (cachedResult != null) {
            logger.warn("Duplicate request received, ignored: {}.", key);
            logger.warn("If you want to unsubscribe from all previous handlers, call the unsubscribe method explicitly.", key);

            context.setResponse(cachedResult.getFirst());
            context.setApiResult(cachedResult.getSecond());

            return;
        }

        CompletableFuture<Pair<WebSocketResponse, ApiResult>> future = locks.computeIfAbsent(key, _k -> {
            responseClassesByTrId.put(trId, apiData.getResponseClass());
            sendMessage(request.toJson());
            return new CompletableFuture<>();
        });

        Pair<WebSocketResponse, ApiResult> apiResult;
        try {
            apiResult = future.get(config.getSocketTimeout().toSeconds(), TimeUnit.SECONDS);

            cache.putIfAbsent(key, apiResult);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            logger.error("Failed to get response from server", e);

            throw new KisClientException("Failed to execute request", e);
        }

        context.setResponse(apiResult.getFirst());
        context.setApiResult(apiResult.getSecond());
    }

    private void ensureConnected() {
        if (session != null && session.isOpen()) {
            return;
        }

        logger.info("Connecting to WebSocket server...");

        try {
            container.connectToServer(this, uri);
        } catch (Exception e) {
            logger.error("WebSocket connection failed", e);
        }
    }

    private boolean sendMessage(String message) {
        ensureConnected();

        try {
            logger.debug("Trying to send a message over WebSocket: {}", message);

            session.getBasicRemote().sendText(message);

            return true;
        } catch (IOException e) {
            logger.error("Failed to send message", message, e);
        }

        return false;
    }

    @Override
    public void close() throws IOException {
        session.close();
    }

}
