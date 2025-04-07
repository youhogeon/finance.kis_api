package com.youhogeon.finance.kis_api.config;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * RoundRobinCredentialsSelector
 *
 * Round-robin credentials selector
 * Caution: credentials가 실행 중간에 변경되는 경우(삭제되는 경우) 의도치 않은 동작이 발생할 수 있습니다.
 */
public class RoundRobinCredentialsSelector extends SimpleCredentialsSelector {

    private final AtomicInteger index = new AtomicInteger(0);
    private volatile Credentials[] credentials = new Credentials[0];

    @Override
    public Credentials getCredentials(Map<String, Credentials> credentialsMap) {
        if (credentialsMap.isEmpty()) {
            throw new IllegalArgumentException("Credentials not found");
        }

        // credentials 배열의 크기가 변경되었으면 재설정
        if (credentialsMap.size() != credentials.length) {
            credentials = credentialsMap.values().toArray(new Credentials[0]);
        }

        int pos = index.getAndIncrement();
        return credentials[pos % credentials.length];
    }

}