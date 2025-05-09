package com.youhogeon.finance.kis_api.config;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * WeightedRoundRobinCredentialsSelector
 *
 * Credentials를 라운드 로빈 방식으로 선택하되, 각 Credentials의 유량 비중을 고려하여 선택합니다.
 * Credentials가 실행 중간에 변경되는 경우(삭제되는 경우) 의도치 않은 동작이 발생할 수 있습니다.
 */
public class WeightedRoundRobinCredentialsSelector extends SimpleCredentialsSelector {

    private final AtomicInteger index = new AtomicInteger(0);
    private volatile Credentials[] wheel = new Credentials[0]; // length == totalWeight

    @Override
    public void setCredentials(Map<String, Credentials> credentials) {
        rebuild(credentials);
    }


    @Override
    public Credentials getCredentials() {
        int pos = Math.abs(index.getAndIncrement() % wheel.length);

        return wheel[pos];
    }

    private void rebuild(Map<String, Credentials> map) {
        int weightSum = map.values().stream().mapToInt(Credentials::getRestLimitPerSecond).sum();
        Credentials[] tmp = new Credentials[weightSum];

        int offset = 0;
        for (Credentials c : map.values()) {
            int limit = c.getRestLimitPerSecond();
            Arrays.fill(tmp, offset, offset + limit, c);
            offset += limit;
        }

        wheel = tmp;
        index.set(0);
    }

}