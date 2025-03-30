package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 주식예약주문정정취소[v1_국내주식-018,019]
 */
@NoArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.POST, path = "/uapi/domestic-stock/v1/trading/order-resv-rvsecncl")
public class OrderResvRvsecnclApi extends CommonRestApi<OrderResvRvsecnclResult> {

    /**
     * CTSC0009U : 국내주식예약취소주문
     * CTSC0013U : 국내주식예약정정주문
     */
    @Header
    private String trId = "CTSC0009U";

    /**
     * 종목코드(6자리)
     *
     * [정정]
     */
    @Body
    private String pdno = "";

    /**
     * 주문수량
     *
     * [정정] 주문주식수
     */
    @Body
    private String ordQty = "";

    /**
     * 주문단가
     *
     * [정정] 1주당 가격
     * * 장전 시간외, 시장가의 경우 1주당 가격을 공란으로 비우지 않음 "0"으로 입력 권고
     */
    @Body
    private String ordUnpr = "";

    /**
     * 매도매수구분코드
     *
     * [정정]
     * 01 : 매도
     * 02 : 매수
     */
    @Body
    private String sllBuyDvsnCd = "";

    /**
     * 주문구분코드
     *
     * [정정]
     * 00 : 지정가
     * 01 : 시장가
     * 02 : 조건부지정가
     * 05 : 장전 시간외
     */
    @Body
    private String ordDvsnCd = "";

    /**
     * 주문대상잔고구분코드
     *
     * [정정]
     * 10 : 현금
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
    private String ordObjtCblcDvsnCd = "";

    /**
     * 대출일자
     *
     * [정정]
     */
    @Body
    private String loanDt = "";

    /**
     * 예약주문종료일자
     *
     * [정정]
     */
    @Body
    private String rsvnOrdEndDt = "";

    /**
     * 연락전화번호
     *
     * [정정]
     */
    @Body
    private String ctalTlno = "";

    /**
     * 예약주문순번
     *
     * [정정/취소]
     */
    @Body
    private String rsvnOrdSeq = "";

    /**
     * 예약주문조직번호
     *
     * [정정/취소]
     */
    @Body
    private String rsvnOrdOrgno = "";

    /**
     * 예약주문주문일자
     *
     * [정정/취소]
     */
    @Body
    private String rsvnOrdOrdDt = "";

}
