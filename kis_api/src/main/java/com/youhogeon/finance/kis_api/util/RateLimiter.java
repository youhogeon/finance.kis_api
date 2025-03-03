package com.youhogeon.finance.kis_api.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimiter {

    private final int limit; // 초당 요청 제한
    private final long windowSizeInMillis; // 제한 창 크기(1초)
    private final Queue<Long> requestTimestamps; // 요청 타임스탬프 기록
    private final Lock lock; // 동기화용 Lock 객체

    public RateLimiter(int limit) {
        this.limit = limit;
        this.windowSizeInMillis = 1000;
        this.requestTimestamps = new LinkedList<>();
        this.lock = new ReentrantLock(); // ReentrantLock 초기화
    }

    public boolean checkAvailablity() {
        return getWaitTime() == 0;
    }

    public long getWaitTime() {
        lock.lock();

        try {
            long now = System.currentTimeMillis();

            // 현재 시간 기준으로 1초를 벗어난 요청은 제거
            while (!requestTimestamps.isEmpty() && requestTimestamps.peek() <= now - windowSizeInMillis) {
                requestTimestamps.poll();
            }

            // 요청 수가 제한보다 적으면 0 반환
            if (requestTimestamps.size() < limit) {
                return 0;
            }

            // 요청 수가 제한보다 많으면 대기 시간 반환
            return windowSizeInMillis - (now - requestTimestamps.peek());
        } finally {
            lock.unlock();
        }
    }

    public void acquire() {
        lock.lock();

        try {
            long waitTime = getWaitTime();

            if (waitTime == 0) {
                long now = System.currentTimeMillis();
                requestTimestamps.add(now);

                return;
            }

            // 제한 초과 시 대기
            try {
                Thread.sleep(waitTime);

                acquire(); // 대기 후 다시 시도
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted", e);
            }
        } finally {
            lock.unlock();
        }
    }

    public void acquireWithoutWaiting() {
        lock.lock();

        try {
            long now = System.currentTimeMillis();

            if (checkAvailablity()) {
                requestTimestamps.add(now);

                return;
            }

            // 제한 초과 시 예외 발생
            throw new RuntimeException("Rate limit exceeded. No waiting allowed.");
        } finally {
            lock.unlock();
        }
    }

}
