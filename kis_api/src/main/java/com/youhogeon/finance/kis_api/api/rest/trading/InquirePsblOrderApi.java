package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.api.annotation.auth.AccountRequired;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 매수가능조회[v1_국내주식-007]
 */
@NoArgsConstructor
@Setter
@AccountRequired(location= AccountRequired.Location.PARAMETER)
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/trading/inquire-psbl-order")
public class InquirePsblOrderApi extends CommonRestApi<InquirePsblOrderResult> {

    /**
     * [실전투자]
     * TTTC8908R : 매수 가능 조회
     *
     * [모의투자]
     * VTTC8908R : 매수 가능 조회
     */
    @Header
    private String trId = "TTTC8908R";

    /**
     * 상품번호
     *
     * 종목번호(6자리)
     * * PDNO, ORD_UNPR 공란 입력 시, 매수수량 없이 매수금액만 조회됨
     */
    @Parameter
    private String pdno = "";

    /**
     * 주문단가
     *
     * 1주당 가격
     * * 시장가(ORD_DVSN:01)로 조회 시, 공란으로 입력
     * * PDNO, ORD_UNPR 공란 입력 시, 매수수량 없이 매수금액만 조회됨
     */
    @Parameter
    private String ordUnpr = "";

    /**
     * 주문구분
     *
     * * 특정 종목 전량매수 시 가능수량을 확인할 경우
     *     00:지정가는 증거금율이 반영되지 않으므로
     *     증거금율이 반영되는 01: 시장가로 조회
     * * 다만, 조건부지정가 등 특정 주문구분(ex.IOC)으로 주문 시 가능수량을 확인할 경우 주문 시와 동일한 주문구분(ex.IOC) 입력하여 가능수량 확인
     * * 종목별 매수가능수량 조회 없이 매수금액만 조회하고자 할 경우 임의값(00) 입력
     * 00 : 지정가
     * 01 : 시장가
     * 02 : 조건부지정가
     * 03 : 최유리지정가
     * 04 : 최우선지정가
     * 05 : 장전 시간외
     * 06 : 장후 시간외
     * 07 : 시간외 단일가
     * 08 : 자기주식
     * 09 : 자기주식S-Option
     * 10 : 자기주식금전신탁
     * 11 : IOC지정가 (즉시체결,잔량취소)
     * 12 : FOK지정가 (즉시체결,전량취소)
     * 13 : IOC시장가 (즉시체결,잔량취소)
     * 14 : FOK시장가 (즉시체결,전량취소)
     * 15 : IOC최유리 (즉시체결,잔량취소)
     * 16 : FOK최유리 (즉시체결,전량취소)
     * 51 : 장중대량
     * 52 : 장중바스켓
     * 62 : 장개시전 시간외대량
     * 63 : 장개시전 시간외바스켓
     * 67 : 장개시전 금전신탁자사주
     * 69 : 장개시전 자기주식
     * 72 : 시간외대량
     * 77 : 시간외자사주신탁
     * 79 : 시간외대량자기주식
     * 80 : 바스켓
     */
    @Parameter
    private String ordDvsn = "00";

    /**
     * CMA평가금액포함여부
     *
     * Y : 포함
     * N : 포함하지 않음
     */
    @Parameter
    private String cmaEvluAmtIcldYn = "";

    /**
     * 해외포함여부
     *
     * Y : 포함
     * N : 포함하지 않음
     */
    @Parameter
    private String ovrsIcldYn = "";

}
