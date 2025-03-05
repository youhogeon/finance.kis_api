package com.youhogeon.finance.kis_api.middleware;

import com.youhogeon.finance.kis_api.KisClient;
import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.context.ApiData;
import com.youhogeon.finance.kis_api.client.http.HttpClientRequest;
import com.youhogeon.finance.kis_api.client.http.HttpClientResponse;
import com.youhogeon.finance.kis_api.config.Credentials;

public interface Middleware {

    /**
     * API 요청 전 실행되는 메서드
     *
     * @param client Client 객체
     * @param api Api Class를 파싱한 정보를 바탕으로 Api 객체에 담은 데이터를 변환한 객체
     * @param request 실제 요청 보낼 데이터
     * @param credentials 인증 정보
     */
    public void before(KisClient client, ApiData api, HttpClientRequest request, Credentials credentials);

    /**
     * API 응답 후 실행되는 메서드
     *
     * @param client Client 객체
     * @param api Api Class를 파싱한 정보를 바탕으로 Api 객체에 담은 데이터를 변환한 객체
     * @param response 실제 응답 받은 데이터
     * @param result API 실행 결과로 반환될 데이터
     * @param credentials 인증 정보
     */
    public void after(KisClient client, ApiData api, HttpClientResponse response, ApiResult result, Credentials credentials);

}
