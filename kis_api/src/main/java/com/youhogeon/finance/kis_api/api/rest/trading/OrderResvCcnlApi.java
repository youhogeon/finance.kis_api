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
 * 주식예약주문조회[v1_국내주식-020]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/order-resv-ccnl")
public class OrderResvCcnlApi extends CommonRestApi<OrderResvCcnlResult> {

    @Header
    private String trId = "CTSC0004R";

    /**
     * 예약주문시작일자
     */
    @Parameter
    @NonNull
    private String rsvnOrdOrdDt;

    /**
     * 예약주문종료일자
     */
    @Parameter
    @NonNull
    private String rsvnOrdEndDt;

    /**
     * 예약주문순번
     */
    @Parameter
    private String rsvnOrdSeq = "";

    /**
     * 단말매체종류코드
     *
     * "00" 입력
     */
    @Parameter
    private String tmnlMdiaKindCd = "00";

    /**
     * 처리구분코드
     *
     * 0: 전체
     * 1: 처리내역
     * 2: 미처리내역
     */
    @Parameter
    private String prcsDvsnCd = "0";

    /**
     * 취소여부
     *
     * "Y" 유효한 주문만 조회
     */
    @Parameter
    private String cnclYn = "";

    /**
     * 상품번호
     *
     * 종목코드(6자리) (공백 입력 시 전체 조회)
     */
    @Parameter
    private String pdno = "";

    /**
     * 매도매수구분코드
     */
    @Parameter
    private String sllBuyDvsnCd = "";

    /**
     * 연속조회검색조건200
     *
     * 다음 페이지 조회시 사용
     */
    @Parameter
    private String ctxAreaFk200 = "";

    /**
     * 연속조회키200
     *
     * 다음 페이지 조회시 사용
     */
    @Parameter
    private String ctxAreaNk200 = "";

}
