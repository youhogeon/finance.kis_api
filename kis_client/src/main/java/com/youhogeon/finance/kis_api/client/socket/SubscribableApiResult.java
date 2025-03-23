package com.youhogeon.finance.kis_api.client.socket;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.api.RealTimeApiData;

public abstract class SubscribableApiResult<T extends RealTimeApiData> implements ApiResult {

    private List<Consumer<T[]>> handlers = new ArrayList<>();
    private UnsubscribeCallback unsubscribeCallback;

    private static Logger logger = LoggerFactory.getLogger(SubscribableApiResult.class);

    /**
     * 수신받은 데이터를 처리할 handler를 등록
     *
     * @param handler 등록할 handler 함수
     */
    public int addHandler(Consumer<T[]> handler) {
        this.handlers.add(handler);

        int size = handlers.size();
        logger.info("New handler subscribed to {}. Total handlers: {}", this.getClass().getSimpleName(), size);

        return size;
    }

    /**
     * 등록했던 handler를 제거
     *
     * @param handler 등록할 handler 함수
     */
    public int removeHandler(Consumer<T[]> handler) {
        this.handlers.remove(handler);

        int size = handlers.size();
        logger.info("Handler unsubscribed from {}. Total handlers: {}", this.getClass().getSimpleName(), size);

        return size;
    }

    /**
     * 모든 handler를 제거하고 서버에 데이터 수신 중단 요청
     */
    public void unsubscribe() {
        this.handlers.clear();

        unsubscribeCallback.onUnsubscribe(this);

        logger.info("All listeners unsubscribed from {}", this.getClass().getSimpleName());
    }

    protected List<Consumer<T[]>> getAllHandlers() {
        return handlers;
    }

    protected void setUnsubscribeCallback(UnsubscribeCallback callback) {
        this.unsubscribeCallback = callback;
    }

}
