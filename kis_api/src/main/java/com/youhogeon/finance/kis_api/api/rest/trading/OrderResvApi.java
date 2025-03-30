package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 주식예약주문[v1_국내주식-017]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.POST, path = "/uapi/domestic-stock/v1/trading/order-resv")
public class OrderResvApi extends CommonRestApi<OrderResvResult> {

    @Header
    private String trId = "CTSC0008U";

    /**
     * 종목코드(6자리)
     */
    @Body
    @NonNull
    private String pdno;

    /**
     * 주문수량
     *
     * 주문주식수
     */
    @Body
    @NonNull
    private String ordQty;

    /**
     * 주문단가
     *
     * 1주당 가격
     * * 장전 시간외, 시장가의 경우 1주당 가격을 공란으로 비우지 않음 "0"으로 입력 권고
     */
    @Body
    @NonNull
    private String ordUnpr;

    /**
     * 매도매수구분코드
     *
     * 01 : 매도
     * 02 : 매수
     */
    @Body
    private String sllBuyDvsnCd = "02";

    /**
     * 주문구분코드
     *
     * 00 : 지정가
     * 01 : 시장가
     * 02 : 조건부지정가
     * 05 : 장전 시간외
     */
    @Body
    @NonNull
    private String ordDvsnCd = "01";

    /**
     * 주문대상잔고구분코드
     *
     * [매도매수구분코드 01:매도/02:매수시 사용]
     * 10 : 현금
     *
     * [매도매수구분코드 01:매도시 사용]
     * 12 : 주식담보대출
     * 14 : 대여상환
     * 21 : 자기융자신규
     * 22 : 유통대주신규
     * 23 : 유통융자신규
     * 24 : 자기대주신규
     * 25 : 자기융자상환
     * 26 : 유통대주상환
     * 27 : 유통융자상환
     * 28 : 자기대주상환
     */
    @Body
    private String ordObjtCblcDvsnCd = "10";

    /**
     * 대출일자
     */
    @Body
    private String loanDt = "";

    /**
     * 예약주문종료일자
     *
     * (YYYYMMDD) 현재 일자보다 이후로 설정해야 함
     * * RSVN_ORD_END_DT(예약주문종료일자)를 안 넣으면 다음날 주문처리되고 예약주문은 종료됨
     * * RSVN_ORD_END_DT(예약주문종료일자)는 익영업일부터 달력일 기준으로 공휴일 포함하여 최대 30일이 되는 일자까지 입력 가능
     */
    @Body
    @NonNull
    private String rsvnOrdEndDt;

    /**
     * 대여일자
     */
    @Body
    private String ldngDt = "";

}
