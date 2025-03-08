package com.youhogeon.finance.kis_api.api;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class CommonLiveResponse<T extends LiveApiData> implements ApiResult {

    private List<Consumer<T>> handlers = new ArrayList<>();

    public void addHandler(Consumer<T> listener) {
        this.handlers.add(listener);
    }

    public void removeHandler(Consumer<T> listener) {
        this.handlers.remove(listener);
    }

    public void unsubscribe(String a) {
        throw new UnsupportedOperationException("Unimplemented method 'unsubscribe'");
    }

}
