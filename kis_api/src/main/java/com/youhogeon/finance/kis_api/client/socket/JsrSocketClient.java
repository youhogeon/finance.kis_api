package com.youhogeon.finance.kis_api.client.socket;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.api.LiveApiData;
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
import lombok.AllArgsConstructor;
import lombok.Getter;

@ClientEndpoint
public class JsrSocketClient extends SocketClient {

    private final Configuration config;
    private Session session;

    private final ConcurrentHashMap<Pair<String, String>, CompletableFuture<Pair<WebSocketResponse, ApiResult>>> locks = new ConcurrentHashMap<>();

    private final Map<String, Class<? extends ApiResult>> responseClassesByTrId = new HashMap<>();
    private final ConcurrentHashMap<Pair<String, String>, Subscriber<?>> subscribers = new ConcurrentHashMap<>();

    private final WebSocketContainer container = ContainerProvider.getWebSocketContainer();
    private final URI uri;

    private static final Logger logger = LoggerFactory.getLogger(JsrSocketClient.class);

    public JsrSocketClient(Configuration config) {
        this.config = config;
        this.uri = URI.create(config.getSocketHost());
    }

    @AllArgsConstructor
    @Getter
    class Subscriber<T extends LiveApiData> {
        SubscribableApiResponse<T> apiResponse;
        List<Consumer<T>> handlers;
        Class<T> dataType;
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
            dispatchDataMessage(message);
        }

        WebSocketResponse response = JsonConverter.fromJson(message, WebSocketResponse.class);

        String trId = response.getHeader("tr_id");
        if (trId.equals("PINGPONG")) {
            return;
        }

        String trKey = response.getHeader("tr_key");
        Pair<String, String> key = Pair.of(trId, trKey);

        Class<? extends ApiResult> responseClass = responseClassesByTrId.get(trId);
        if (responseClass == null) {
            logger.error("Response class not found for trId: {}", trId);

            return;
        }

        ApiResult apiResult;

        try {
            apiResult = responseClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            logger.error("Invalid response class {} for trId: {}", trId, responseClass);

            return;
        }

        Pair<WebSocketResponse, ApiResult> data = Pair.of(response, apiResult);
        CompletableFuture<Pair<WebSocketResponse, ApiResult>> future = locks.remove(key);

        if (future != null) {
            future.complete(data);
        } else {
            logger.warn("The server sent a response for data that was not requested: {}", response);
        }
    }

    private boolean isDataResponse(String message) {
        return message.charAt(0) != '{';
    }

    private void dispatchDataMessage(String message) {
        Pair<String, String> key = Pair.of("H0STCNT0", "005930");

        Subscriber<?> subscriber = subscribers.get(key);

        if (subscriber == null) {
            logger.warn("No subscriber found for data message: {}", message);

            return;
        }

        _dispatchSubscriber(subscriber);
    }

    private <T extends LiveApiData> void _dispatchSubscriber(Subscriber<T> subscriber) {
        T data;
        try {
            data = subscriber.getDataType().getDeclaredConstructor().newInstance();

            subscriber.getHandlers().forEach(handler -> handler.accept(data));
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {

        }
    }

    @SuppressWarnings("unchecked")
    private <T extends LiveApiData> Class<T> getDataType(SubscribableApiResponse<T> subscriber) {
        Type generic = subscriber.getClass().getGenericSuperclass();

        if (generic == null || generic == Object.class) {
            Type[] genericInterfaces = subscriber.getClass().getGenericInterfaces();

            if (genericInterfaces.length == 0) {
                return null;
            }

            generic = genericInterfaces[0];
        }

        ParameterizedType parameterizedType = (ParameterizedType) generic;

        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public void execute(ApiContext context) throws IOException {
        ApiData apiData = context.getApiData();
        WebSocketRequest request = (WebSocketRequest) context.getRequest();

        String trId = request.getBody().get("tr_id").toString();
        Pair<String, String> key = Pair.of(trId, request.getBody().get("tr_key").toString());

        Subscriber<?> existedSubscriber = subscribers.get(key);
        if (existedSubscriber != null) {
            logger.warn("Duplicate request received. Current request is ignored: {}.", key);
            logger.warn("If you want to unsubscribe from all previous handlers, call the unsubscribe method explicitly.", key);

            context.setApiResult(existedSubscriber.getApiResponse());

            return;
        }

        CompletableFuture<Pair<WebSocketResponse, ApiResult>> future = locks.computeIfAbsent(key, _k -> {
            responseClassesByTrId.put(trId, apiData.getResponseClass());
            sendMessage(request.toJson());
            return new CompletableFuture<>();
        });

        Pair<WebSocketResponse, ApiResult> result;
        try {
            result = future.get(config.getSocketTimeout().toSeconds(), TimeUnit.SECONDS);

            SubscribableApiResponse<?> apiResult = (SubscribableApiResponse<?>) result.getSecond();
            Class<? extends LiveApiData> dataType = getDataType(apiResult);

            @SuppressWarnings("unchecked")
            List<Consumer<?>> handlersList = (List<Consumer<?>>)(List<?>)apiResult.getAllHandlers();

            @SuppressWarnings({ "unchecked", "rawtypes" })
            Subscriber<?> subscriber = new Subscriber(apiResult, handlersList, dataType);

            subscribers.putIfAbsent(key, subscriber);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            logger.error("Failed to get response from server", e);

            throw new KisClientException("Failed to execute request", e);
        }

        context.setResponse(result.getFirst());
        context.setApiResult(result.getSecond());
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

    @Override
    public int hashCode() {
        if (this.session == null) {
            return -1;
        }

        return this.session.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        JsrSocketClient other = (JsrSocketClient) obj;

        return this.session == other.session;
    }

}
