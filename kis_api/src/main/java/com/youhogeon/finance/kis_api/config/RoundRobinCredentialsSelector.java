package com.youhogeon.finance.kis_api.config;

import java.util.Map;

/**
 * RoundRobinCredentialsSelector
 *
 * Round-robin credentials selector
 * Caution: credentials가 실행 중간에 변경되는 경우(삭제되는 경우) 의도치 않은 동작이 발생할 수 있습니다.
 */
public class RoundRobinCredentialsSelector extends SimpleCredentialsSelector {

    private int index = 0;
    private Credentials[] credentials = new Credentials[0];

    @Override
    public Credentials getCredentials(Map<String, Credentials> credentials) {
        if (credentials.isEmpty()) {
            throw new IllegalArgumentException("Credentials not found");
        }

        if (credentials.size() != this.credentials.length) {
            this.credentials = credentials.values().toArray(new Credentials[0]);
        }

        return this.credentials[index++ % this.credentials.length];
    }

}
