package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 기간별손익일별합산조회[v1_국내주식-052]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired(location= AccountRequired.Location.PARAMETER)
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/inquire-period-profit")
public class InquirePeriodProfitApi extends CommonRestApi<InquirePeriodProfitResult> {

    @Header
    private String trId = "TTTC8708R";

    /**
     * 조회시작일자
     */
    @Parameter
    @NonNull
    private String inqrStrtDt;

    /**
     * 조회종료일자
     */
    @Parameter
    @NonNull
    private String inqrEndDt;

    /**
     * 상품번호
     *
     * ""공란입력 시, 전체
     */
    @Parameter
    @NonNull
    private String pdno = "";

    /**
     * 정렬구분
     *
     * 00: 최근 순, 01: 과거 순, 02: 최근 순
     */
    @Parameter
    private String sortDvsn = "00";

    /**
     * 조회구분
     *
     * 00 입력
     */
    @Parameter
    private String inqrDvsn = "00";

    /**
     * 잔고구분
     *
     *  00: 전체
     */
    @Parameter
    private String cblcDvsn = "00";

    /**
     * 연속조회키100
     */
    @Parameter
    private String ctxAreaNk100 = "";

    /**
     * 연속조회검색조건100
     */
    @Parameter
    private String ctxAreaFk100 = "";

}
