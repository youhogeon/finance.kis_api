package com.youhogeon.finance.kis_api.client.socket;


@FunctionalInterface
public interface UnsubscribeCallback {
    void onUnsubscribe(SubscribableApiResult<?> source);
}