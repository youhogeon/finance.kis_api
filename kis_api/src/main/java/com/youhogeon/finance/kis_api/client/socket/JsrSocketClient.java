package com.youhogeon.finance.kis_api.client.socket;

import java.io.IOException;
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
import com.youhogeon.finance.kis_api.util.CollectionUtil;
import com.youhogeon.finance.kis_api.util.JsonUtil;
import com.youhogeon.finance.kis_api.util.Pair;
import com.youhogeon.finance.kis_api.util.ReflectionUtil;
import com.youhogeon.finance.kis_api.util.StringUtil;

import jakarta.websocket.ClientEndpoint;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;
import lombok.AllArgsConstructor;
import lombok.Getter;

class Key extends Pair<String, String> {

    public Key(String a, String b) {
        super(a, b);
    }

}

@ClientEndpoint
public class JsrSocketClient extends SocketClient {

    private final Configuration config;
    private Session session;

    private final ConcurrentHashMap<Key, CompletableFuture<WebSocketResponse>> locks = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Key, SubscriberInfo<?>> subscribers = new ConcurrentHashMap<>();

    private final WebSocketContainer container = ContainerProvider.getWebSocketContainer();
    private final URI uri;

    private String aesKey;
    private String ivKey;

    private static final Logger logger = LoggerFactory.getLogger(JsrSocketClient.class);

    public JsrSocketClient(Configuration config) {
        this.config = config;
        this.uri = URI.create(config.getSocketHost());
    }

    @AllArgsConstructor
    @Getter
    class SubscriberInfo<T extends LiveApiData> {
        SubscribableApiResult<T> apiResult;
        List<Consumer<T[]>> handlers;
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
            processDataMessage(message);

            return;
        }

        WebSocketResponse response = JsonUtil.fromJson(message, WebSocketResponse.class);

        String trId = response.getHeader("tr_id");
        if (trId.equals("PINGPONG")) {
            sendMessage(message); // echo PONG

            return;
        }

        String trKey = response.getHeader("tr_key");
        Key key = new Key(trId, trKey);

        CompletableFuture<WebSocketResponse> future = locks.remove(key);

        if (future != null) {
            future.complete(response);
        } else {
            logger.warn("The server sent a response for data that was not requested: {}", response);
        }
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

    private boolean isDataResponse(String message) {
        return message.charAt(0) != '{';
    }

    private void processDataMessage(String message) {
        int i1 = message.indexOf('|');
        int i2 = message.indexOf('|', i1 + 1);
        int i3 = message.indexOf('|', i2 + 1);

        boolean isEncrypted = message.substring(0, i1).equals("1");
        String trId = message.substring(i1 + 1, i2);
        int size = Integer.parseInt(message.substring(i2 + 1, i3));

        String stringBody = message.substring(i3 + 1);

        String[][] body = parseBody(stringBody, isEncrypted, size);
        String trKey = body[0][0];

        Key key = new Key(trId, trKey);

        dispatch(key, body);
    }

    private <T extends LiveApiData> void dispatch(Key key, String[][] body) {
        @SuppressWarnings("unchecked")
        SubscriberInfo<T> subscriber = (SubscriberInfo<T>)subscribers.get(key);

        if (subscriber == null) {
            logger.warn("No subscriber found for data message: {}", key);

            return;
        }

        Class<T> dataType = subscriber.getDataType();
        T[] data = ReflectionUtil.createObjects(body, dataType);

        subscriber.getHandlers().forEach(handler -> {
            handler.accept(data);
        });
    }

    @Override
    public void execute(ApiContext context) throws IOException {
        ApiData apiData = context.getApiData();
        WebSocketRequest request = (WebSocketRequest) context.getRequest();

        String trId = request.getBody().get("tr_id").toString();
        String trKey = request.getBody().get("tr_key").toString();
        Key key = new Key(trId, trKey);

        Class<? extends ApiResult> responseClass = apiData.getResponseClass();
        if (responseClass == null) {
            logger.error("Response class not found for trId: {}", trId);

            return;
        }

        SubscriberInfo<?> existedSubscriber = subscribers.get(key);
        if (existedSubscriber != null) {
            logger.warn("Duplicate request received. Current request is ignored: {}.", key);
            logger.warn("If you want to unsubscribe from all previous handlers, call the unsubscribe method explicitly.", key);

            context.setApiResult(existedSubscriber.getApiResult());

            return;
        }

        CompletableFuture<WebSocketResponse> future = locks.computeIfAbsent(key, _k -> {
            sendMessage(request.toJson());

            return new CompletableFuture<>();
        });


        WebSocketResponse response;

        try {
            response = future.get(config.getSocketTimeout().toSeconds(), TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            logger.error("Failed to get response from server", e);

            throw new KisClientException("Failed to execute request", e);
        }

        @SuppressWarnings({ "rawtypes", "unchecked" })
        SubscriberInfo<?> subscriber = subscribers.computeIfAbsent(key, k -> {
            try {
                SubscribableApiResult<?> apiResult = (SubscribableApiResult<?>) responseClass.getDeclaredConstructor().newInstance();
                Class<? extends LiveApiData> dataType = getDataType(apiResult);

                setEncryptionKeys(response);

                List<Consumer<?>> handlersList = (List<Consumer<?>>)(List<?>)apiResult.getAllHandlers();

                return new SubscriberInfo(apiResult, handlersList, dataType);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                logger.error("Invalid response class {} for trId: {}", trId, responseClass);
                throw new RuntimeException(e);
            }
        });

        context.setResponse(response);
        context.setApiResult(subscriber.getApiResult());
    }

    private void setEncryptionKeys(WebSocketResponse response) {
        Map<String, String> output = response.getBody().getOutput();

        aesKey = output.get("aes_key");
        ivKey = output.get("iv_key");
    }

    private String[][] parseBody(String body, boolean isEncrypted, int size) {
        if (isEncrypted) {
            body = StringUtil.decryptAes256(body, aesKey, ivKey);
        }

        String[] splited = StringUtil.fastSplit(body, '|');

        if (splited.length % size != 0) {
            logger.error("Invalid body size: {}", body);

            return null;
        }

        String[][] splitted = CollectionUtil.splitArray(splited, size);

        return splitted;
    }

    @SuppressWarnings("unchecked")
    private <T extends LiveApiData> Class<T> getDataType(SubscribableApiResult<T> subscriber) {
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
