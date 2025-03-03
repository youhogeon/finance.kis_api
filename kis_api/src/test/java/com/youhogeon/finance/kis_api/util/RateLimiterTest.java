package com.youhogeon.finance.kis_api.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;

public class RateLimiterTest {

    // Test 1: 요청이 초과되면 대기 후 처리되는지 확인
    @Test
    public void testRateLimitExceedAndWait() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(2); // 초당 2개의 요청만 허용

        long startTime = System.currentTimeMillis();

        // 첫 번째와 두 번째 요청은 처리된다.
        rateLimiter.acquire(); // 첫 번째 요청
        rateLimiter.acquire(); // 두 번째 요청

        // 세 번째 요청은 제한을 초과하므로 대기해야 한다.
        rateLimiter.acquire(); // 세 번째 요청

        long endTime = System.currentTimeMillis();

        // 실제 대기 시간이 예상 시간보다 길어야 한다.
        // 초과된 요청 후 대기 시간 (1초 기준)으로 대기해야 하기 때문에, 대기 시간이 최소 1초 이상이어야 한다.
        assertTrue(endTime - startTime >= 1000, "Expected waiting time should be at least 1 second");
    }

    // Test 1-2: 요청이 초과되면 대기 후 처리되는지 확인
    @Test
    public void testRateLimitExceedAndWait2() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(2);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
        }

        long endTime = System.currentTimeMillis();

        assertTrue(endTime - startTime >= 4000, "Expected waiting time should be at least 1 second");
    }

    // Test 2: 요청이 제한 내에서 처리되는 경우
    @Test
    public void testRateLimitWithinLimit() {
        RateLimiter rateLimiter = new RateLimiter(3); // 초당 3개의 요청만 허용

        // 3번의 요청이 모두 정상적으로 처리되어야 한다.
        for (int i = 0; i < 3; i++) {
            assertTrue(rateLimiter.checkAvailablity(), "Request should be processed");
            rateLimiter.acquire();  // 요청 처리
        }
    }

    // Test 3: 동시성 테스트 (여러 스레드에서 acquire와 checkAvailablity 호출)
    @Test
    public void testConcurrency() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5);

        CountDownLatch latch = new CountDownLatch(10); // 10개의 스레드가 동시에 동작
        Runnable task = () -> {
            try {
                rateLimiter.acquire();
                assertTrue(rateLimiter.checkAvailablity(), "Request should be processed");
            } finally {
                latch.countDown();  // 완료 시 카운트 다운
            }
        };

        // 10개의 스레드 실행
        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }

        latch.await();  // 모든 스레드가 끝날 때까지 대기
    }

}
