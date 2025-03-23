package com.youhogeon.finance.kis_api.client.socket;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
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

import com.youhogeon.finance.kis_api.api.RealTimeApiData;
import com.youhogeon.finance.kis_api.api.realtime.TransactionType;
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

    private static final Map<String, String> SUCCESS_MSG_CD = Map.of(
        "OPSP0000", "SUBSCRIBE SUCCESS",
        "OPSP0001", "UNSUBSCRIBE SUCCESS"
    );

    private static final Logger logger = LoggerFactory.getLogger(JsrSocketClient.class);

    public JsrSocketClient(Configuration config) {
        this.config = config;
        this.uri = URI.create(config.getSocketHost());
    }

    @AllArgsConstructor
    @Getter
    class SubscriberInfo<T extends RealTimeApiData> {
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

        processStateMessage(message);
    }

    private void ensureConnected() {
        if (session != null && session.isOpen()) {
            return;
        }

        try {
            synchronized (this) {
                if (session != null && session.isOpen()) {
                    return;
                }

                logger.info("Connecting to WebSocket server...");

                container.connectToServer(this, uri);
            }
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

    private void processStateMessage(String message) {
        WebSocketResponse response = JsonUtil.fromJson(message, WebSocketResponse.class);

        String trId = response.getHeader("tr_id");
        if (trId.equals("PINGPONG")) {
            sendMessage(message); // echo PONG

            return;
        }

        if (response.getBody() == null || !SUCCESS_MSG_CD.containsKey(response.getBody().getMsgCd())) {
            throw new KisClientException("Server sent a failure message: " + response);
        }

        String trKey = response.getHeader("tr_key");
        Key key = new Key(trId, trKey);

        CompletableFuture<WebSocketResponse> future = locks.remove(key);

        if (future != null) {
            future.complete(response);
        } else {
            logger.warn("server sent a response for unknown key and data: {} / {}", key, response);
        }
    }

    private <T extends RealTimeApiData> void dispatch(Key key, String[][] body) {
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
        WebSocketRequest unsubscribeRequest = request.clone();

        String trId = request.getBody().get("tr_id").toString();
        String trKey = request.getBody().get("tr_key").toString();
        Key key = new Key(trId, trKey);

        @SuppressWarnings("unchecked")
        Class<SubscribableApiResult<?>> responseClass = (Class<SubscribableApiResult<?>>) apiData.getResponseClass();
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

        @SuppressWarnings({ "rawtypes", "unchecked" })
        SubscriberInfo<?> subscriber = subscribers.computeIfAbsent(key, k -> {
            WebSocketResponse response = sendMessage(key, request);

            try {
                SubscribableApiResult<?> apiResult = responseClass.getDeclaredConstructor().newInstance();

                apiResult.setUnsubscribeCallback((UnsubscribeCallback) (source) -> {
                    logger.info("Trying to send unsubscribe request {}", key);

                    if (!subscribers.containsKey(key)) {
                        logger.warn("No subscriber found for key (it may already have been unsubscribed): {}", key);

                        return;
                    }

                    unsubscribeRequest.getHeaders().put("tr_type", TransactionType.UNSUBSCRIBE); // unsubscribe

                    sendMessage(key, unsubscribeRequest);
                    subscribers.remove(key);

                    logger.info("Unsubscribe request sent successfully for {}", key);
                });

                Class<? extends RealTimeApiData> dataType = ReflectionUtil.getGenericParameterType(apiResult);
                List<Consumer<?>> handlersList = (List<Consumer<?>>)(List<?>)apiResult.getAllHandlers();

                setEncryptionKeys(response);
                context.setResponse(response);

                return new SubscriberInfo(apiResult, handlersList, dataType);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                logger.error("Invalid response class {} for trId: {}", trId, responseClass);
                throw new RuntimeException(e);
            }
        });

        context.setApiResult(subscriber.getApiResult());
    }

    private WebSocketResponse sendMessage(Key key, WebSocketRequest request) {
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

        return response;
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

        String[] splited = StringUtil.fastSplit(body, '^');

        if (splited.length % size != 0) {
            logger.error("Invalid body size: {}", body);

            return null;
        }

        String[][] splitted = CollectionUtil.splitArray(splited, size);

        return splitted;
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
