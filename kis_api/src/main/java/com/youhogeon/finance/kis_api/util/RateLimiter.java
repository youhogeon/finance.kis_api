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
        while (true) { // 재귀 대신 루프 사용
            synchronized (this) {
                long now = System.currentTimeMillis();

                // 1초를 벗어난 오래된 요청 제거
                while (!requestTimestamps.isEmpty() && requestTimestamps.peek() <= now - windowSizeInMillis) {
                    requestTimestamps.poll();
                }

                // 허용된 요청 개수보다 적으면 진행
                if (requestTimestamps.size() < limit) {
                    requestTimestamps.add(now);
                    return; // 요청 허용 후 종료
                }

                // 초과 시 대기 시간 계산
                long earliestRequest = requestTimestamps.peek();
                long waitTime = windowSizeInMillis - (now - earliestRequest);

                if (waitTime > 0) {
                    try {
                        this.wait(waitTime); // Thread.sleep() 대신 wait() 사용
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Thread interrupted", e);
                    }
                }
            }
        }
    }
}
