package com.youhogeon.finance.kis_api.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * API 인증 정보
 */
@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Credentials {

    @NonNull
    private String apiKey;

    @NonNull
    private String apiSecret;

    @Builder.Default
    private int restLimitPerSecond = 20;

    @Builder.Default
    private int socketLimitPerSecond = 41;

}
