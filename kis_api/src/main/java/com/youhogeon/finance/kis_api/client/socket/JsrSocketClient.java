package com.youhogeon.finance.kis_api.client.socket;

import java.io.IOException;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youhogeon.finance.kis_api.client.NetworkRequest;
import com.youhogeon.finance.kis_api.config.Configuration;
import com.youhogeon.finance.kis_api.context.ApiContext;
import com.youhogeon.finance.kis_api.context.ApiData;

import jakarta.websocket.ClientEndpoint;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;

@ClientEndpoint
public class JsrSocketClient extends SocketClient {

    private Configuration config;
    private Session session;

    WebSocketContainer container = ContainerProvider.getWebSocketContainer();
    URI uri;

    private static final Logger logger = LoggerFactory.getLogger(JsrSocketClient.class);

    public JsrSocketClient(Configuration config) {
        this.config = config;
        this.uri = URI.create(config.getSocketHost());
    }

    @OnOpen
    public void onOpen(Session session) {
        logger.info("Connected to websocket server");

        this.session = session;
        // System.out.println("서버에 연결됨");
        // sendMessage("{\r\n" + //
        //                 "    \"header\": {\r\n" + //
        //                 "\"approval_key\": \"b12be3a3-\",\r\n" + //
        //                 "\"custtype\": \"P\",\r\n" + //
        //                 "\"tr_type\": \"1\",\r\n" + //
        //                 "\"content-type\": \"utf-8\"\r\n" + //
        //                 "    },\r\n" + //
        //                 "    \"body\": {\"input\":{\r\n" + //
        //                 "\"tr_id\": \"H0STCNT0\",\r\n" + //
        //                 "\"tr_key\": \"005930\"\r\n" + //
        //                 "    }\r\n" + //
        //                 "}}");
    }

    @OnMessage
    public void onMessage(String message) {
        // pingpong 처리
        // config.getSocketListener().onMessage(message);
        System.out.println("수신한 메시지: " + message);
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

    @Override
    public void execute(ApiContext context) throws IOException {
        ensureConnected();

        // do something
        // 연결성공메시지 반환
        // return {"header":{"tr_id":"H0STCNT0","tr_key":"005930","encrypt":"N"},"body":{"rt_cd":"0","msg_cd":"OPSP0000","msg1":"SUBSCRIBE SUCCESS","output":{"iv":"55ce3d099479ce11","key":"tvldhmfplvgcovaqrspclzhdotfzzequ"}}}
    }

    @Override
    public void close() throws IOException {
        session.close();
    }

    @Override
    public NetworkRequest makeRequest(ApiData apiData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeRequest'");
    }

}
