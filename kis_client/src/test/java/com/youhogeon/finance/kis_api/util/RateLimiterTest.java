package com.youhogeon.finance.kis_api.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RateLimiterTest {

    // Test 1: 요청이 초과되면 대기 후 처리되는지 확인
    @Test
    public void testWaiting() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(2);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 8; i++) {
            rateLimiter.acquire();
        }

        long endTime = System.currentTimeMillis();

        assertTrue(endTime - startTime >= 3000, "Expected waiting time should be at least 3 second");
    }

    // Test 1-2: 요청이 초과되면 대기 후 처리되는지 확인
    @Test
    public void testWaiting2() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(50);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            rateLimiter.acquire();
        }

        long endTime = System.currentTimeMillis();

        assertTrue(endTime - startTime >= 1000, "Expected waiting time should be at least 1 second");
    }

    // Test 1-3: 요청이 초과되면 대기 후 처리되는지 확인
    @Test
    public void testWaiting3() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(1);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 3; i++) {
            rateLimiter.acquire();
        }

        long endTime = System.currentTimeMillis();

        assertTrue(endTime - startTime >= 2000, "Expected waiting time should be at least 2 second");
    }

    // Test 2: Waiting 안하는 경우
    @Test
    public void testNotWaiting() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(500);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 500; i++) {
            rateLimiter.acquire();
        }

        long endTime = System.currentTimeMillis();

        assertTrue(endTime - startTime < 1000);
    }

    // Test 3: 여러 Thread가 요청을 보내는 경우, 요청이 초과되면 대기 후 처리되는지 확인
    @Test
    public void testThreadSafety() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(10);

        long startTime = System.currentTimeMillis();

        Runnable task = () -> {
            rateLimiter.acquire();
        };

        Thread[] threads = new Thread[30];
        for (int i = 0; i < 30; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long endTime = System.currentTimeMillis();

        assertTrue(endTime - startTime >= 2000, "Expected waiting time should be at least 1 second");
    }

}
