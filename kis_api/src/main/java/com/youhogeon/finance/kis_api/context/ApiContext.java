package com.youhogeon.finance.kis_api.context;

import com.youhogeon.finance.kis_api.api.ApiResult;
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
 * @param api Api Class를 파싱한 정보를 바탕으로 Api 객체에 담은 데이터를 변환한 객체
 * @param request 실제 요청 보낼 데이터
 * @param response 실제 응답 받은 데이터
 * @param result API 실행 결과로 반환될 데이터
 */
@Data
@RequiredArgsConstructor
public class ApiContext {

    @NonNull Credentials credentials;

    ApiData apiData;
    NetworkRequest request;

    NetworkResponse response;
    ApiResult apiResult;

}
