package com.youhogeon.finance.kis_api.context;

import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.client.NetworkClient;
import com.youhogeon.finance.kis_api.client.NetworkRequest;
import com.youhogeon.finance.kis_api.client.NetworkResponse;
import com.youhogeon.finance.kis_api.config.Credentials;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * API 요청에 대한 정보를 담은 객체
 */
@Data
@NoArgsConstructor
public class ApiContext {

    public ApiContext(Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * 인증 정보
     */
    private @NonNull Credentials credentials;

    /**
     * Api Class에서 추출한 데이터를 담은 객체
     */
    private @NonNull ApiData apiData;

    private @NonNull NetworkClient networkClient;

    /**
     * 서버에 요청 보낼 데이터를 담은 객체
     */
    private NetworkRequest request;

    /**
     * 서버로부터 응답 받은 데이터를 담은 객체
     */
    private NetworkResponse response;

    /**
     * 최종적으로 반환될 데이터를 담은 객체
     */
    private ApiResult apiResult;

}
