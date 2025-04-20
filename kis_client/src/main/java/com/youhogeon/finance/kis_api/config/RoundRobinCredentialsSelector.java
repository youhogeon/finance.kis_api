package com.youhogeon.finance.kis_api.config;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * RoundRobinCredentialsSelector
 *
 * Credentials를 라운드 로빈 방식으로 (번갈아가며) 선택합니다.
 * * Credentials가 실행 중간에 변경되는 경우(삭제되는 경우) 의도치 않은 동작이 발생할 수 있습니다.
 * * Credentials 간 유량(restLimitPerSecond)이 다른 경우 WeightedRoundRobinCredentialsSelector를 사용하세요.
 */
public class RoundRobinCredentialsSelector extends SimpleCredentialsSelector {

    private final AtomicInteger index = new AtomicInteger(0);
    private volatile Credentials[] credentials = new Credentials[0];

    @Override
    public Credentials getCredentials(Map<String, Credentials> credentialsMap) {
        if (credentialsMap.isEmpty()) {
            throw new IllegalArgumentException("Credentials not found");
        }

        if (credentialsMap.size() != credentials.length) {
            credentials = credentialsMap.values().toArray(new Credentials[0]);
        }

        int pos = index.getAndIncrement();
        return credentials[pos % credentials.length];
    }

}