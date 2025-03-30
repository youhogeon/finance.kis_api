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
 * 주식일별주문체결조회[v1_국내주식-005]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/inquire-daily-ccld")
public class InquireDailyCcldApi extends CommonRestApi<InquireDailyCcldResult> {

    /**
     * [실전투자]
     * 3개월이내 TTTC0081R
     * 3개월이전 CTSC9215R
     */
    @Header
    private String trId = "TTTC0081R";

    /**
     * 조회시작일자
     *
     * YYYYMMDD
     */
    @Parameter
    @NonNull
    private String inqrStrtDt;

    /**
     * 조회종료일자
     *
     * YYYYMMDD
     */
    @Parameter
    @NonNull
    private String inqrEndDt;

    /**
     * 매도매수구분코드
     *
     * 00 : 전체 / 01 : 매도 / 02 : 매수
     */
    @Parameter
    private String sllBuyDvsnCd = "00";

    /**
     * 상품번호
     *
     * 종목번호(6자리)
     */
    @Parameter
    private String pdno = "";

    /**
     * 주문채번지점번호
     *
     * 주문시 한국투자증권 시스템에서 지정된 영업점코드
     */
    @Parameter
    private String ordGnoBrno = "";

    /**
     * 주문번호
     *
     * 주문시 한국투자증권 시스템에서 채번된 주문번호
     */
    @Parameter
    private String odno = "";

    /**
     * 체결구분
     *
     * 00 전체
     * 01 체결
     * 02 미체결
     */
    @Parameter
    private String ccldDvsn = "00";

    /**
     * 조회구분
     *
     * 00 역순
     * 01 정순
     */
    @Parameter
    private String inqrDvsn = "00";

    /**
     * 조회구분1
     *
     * 없음: 전체
     * 1: ELW
     * 2: 프리보드
     */
    @Parameter
    private String inqrDvsn1 = "";

    /**
     * 조회구분3
     *
     * 00 전체
     * 01 현금
     * 02 신용
     * 03 담보
     * 04 대주
     * 05 대여
     * 06 자기융자신규/상환
     * 07 유통융자신규/상환
     */
    @Parameter
    private String inqrDvsn3 = "00";

    /**
     * 거래소ID구분코드
     *
     * KRX : KRX  NXT : NXT
     */
    @Parameter
    @NonNull
    private String excgIdDvsnCd;

    /**
     * 연속조회검색조건100
     *
     * '공란 : 최초 조회시는
     * 이전 조회 Output CTX_AREA_FK100 값 : 다음페이지 조회시(2번째부터)'
     */
    @Parameter
    private String ctxAreaFk100 = "";

    /**
     * 연속조회키100
     *
     * '공란 : 최초 조회시
     * 이전 조회 Output CTX_AREA_NK100 값 : 다음페이지 조회시(2번째부터)'
     */
    @Parameter
    private String ctxAreaNk100 = "";

}
