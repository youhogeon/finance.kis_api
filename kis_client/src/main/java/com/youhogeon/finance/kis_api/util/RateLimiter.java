package com.youhogeon.finance.kis_api.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimiter {

    private final int limit; // 초당 허용 요청 수
    private final long windowSizeInMillis = 1000; // 1초 단위
    private final Queue<Long> requestTimestamps = new ConcurrentLinkedQueue<>();

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public RateLimiter(int limit) {
        this.limit = limit;
    }

    public void acquire() {
        lock.lock();

        try {
            while (true) {
                long now = System.currentTimeMillis();

                while (!requestTimestamps.isEmpty() && requestTimestamps.peek() <= now - windowSizeInMillis) {
                    requestTimestamps.poll();
                }

                if (requestTimestamps.size() < limit) {
                    requestTimestamps.add(now);
                    condition.signalAll();
                    return;
                }

                long earliest = requestTimestamps.peek();
                long waitTime = windowSizeInMillis - (now - earliest);

                if (waitTime > 0) {
                    try {
                        condition.await(waitTime, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Thread interrupted", e);
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public int getRemainingQuota() {
        lock.lock();

        try {
            long now = System.currentTimeMillis();

            while (!requestTimestamps.isEmpty() && requestTimestamps.peek() <= now - windowSizeInMillis) {
                requestTimestamps.poll();
            }

            return limit - requestTimestamps.size();
        } finally {
            lock.unlock();
        }
    }

}
