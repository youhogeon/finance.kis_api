package com.youhogeon.finance.kis_api.context;

import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.client.NetworkClient;
import com.youhogeon.finance.kis_api.client.NetworkRequest;
import com.youhogeon.finance.kis_api.client.NetworkResponse;
import com.youhogeon.finance.kis_api.config.Credentials;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * API 요청에 대한 정보를 담은 객체
 */
@Data
@RequiredArgsConstructor
public class ApiContext {

    /**
     * 인증 정보
     */
    private @NonNull Credentials credentials;

    /**
     * Api Class에서 추출한 데이터를 담은 객체
     */
    private ApiData apiData;

    private NetworkClient networkClient;

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
