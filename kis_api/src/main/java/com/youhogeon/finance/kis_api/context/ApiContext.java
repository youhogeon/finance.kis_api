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
 *
 * @param credentials 인증 정보
 * @param apiData Api 객체에서 추출한 데이터(Api Class를 파싱한 정보를 바탕으로)를 담은 객체
 * @param request 서버에 요청 보낼 데이터를 담은 객체
 * @param response 서버로부터 응답 받은 데이터를 담은 객체
 * @param apiResult 최종적으롭 반환될 데이터를 담은 객체
 */
@Data
@RequiredArgsConstructor
public class ApiContext {

    NetworkClient networkClient;
    @NonNull Credentials credentials;

    ApiData apiData;
    NetworkRequest request;

    NetworkResponse response;
    ApiResult apiResult;

}
