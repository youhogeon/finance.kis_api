package com.youhogeon.finance.kis_api.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RateLimiter {

    private final int limit; // 초당 허용 요청 수
    private final long windowSizeInMillis = 1000; // 1초 단위
    private final Queue<Long> requestTimestamps = new ConcurrentLinkedQueue<>();

    public RateLimiter(int limit) {
        this.limit = limit;
    }

    public void acquire() {
        while (true) {
            synchronized (this) {
                long now = System.currentTimeMillis();

                // 오래된 요청 제거
                while (!requestTimestamps.isEmpty() && requestTimestamps.peek() <= now - windowSizeInMillis) {
                    requestTimestamps.poll();
                }
                if (requestTimestamps.size() < limit) {
                    requestTimestamps.add(now);
                    return;
                }

                long earliestRequest = requestTimestamps.peek();
                long waitTime = windowSizeInMillis - (now - earliestRequest);

                if (waitTime > 0) {
                    try {
                        this.wait(waitTime);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Thread interrupted", e);
                    }
                }
            }
        }
    }
}
