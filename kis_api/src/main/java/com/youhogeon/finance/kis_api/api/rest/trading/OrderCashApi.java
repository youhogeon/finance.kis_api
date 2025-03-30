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
 * 주식주문(현금)[v1_국내주식-001]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.POST, path = "/uapi/domestic-stock/v1/trading/order-cash")
public class OrderCashApi extends CommonRestApi<OrderCashResult> {

    /**
     * 국내주식주문 매도 : TTTC0011U
     * 국내주식주문 매도(모의투자) : VTTC0011U
     * 국내주식주문 매수 : TTTC0012U
     * 국내주식주문 매수(모의투자) : VTTC0012U'
     */
    @Header
    private String trId = "TTTC0012U";

    /**
     * 상품번호
     *
     * 종목코드(6자리)
     */
    @Body
    @NonNull
    private String pdno;

    /**
     * 매도유형 (매도주문 시)
     *
     * 01@일반매도
     * 02@임의매매
     * 05@대차매도
     * → 미입력시 01 일반매도로 진행
     */
    @Body
    private String sllType = "01";

    /**
     * 주문구분
     *
     * 00@지정가
     * 01@시장가
     * 02@조건부지정가
     * 03@최유리지정가
     * 04@최우선지정가
     * 05@장전 시간외
     * 06@장후 시간외
     * 07@시간외 단일가
     * 65@경매매
     * 08@자기주식
     * 09@자기주식S-Option
     * 10@자기주식금전신탁
     * 11@IOC지정가 (즉시체결,잔량취소)
     * 12@FOK지정가 (즉시체결,전량취소)
     * 13@IOC시장가 (즉시체결,잔량취소)
     * 14@FOK시장가 (즉시체결,전량취소)
     * 15@IOC최유리 (즉시체결,잔량취소)
     * 16@FOK최유리 (즉시체결,전량취소)
     * 51@장중대량
     * 52@장중바스켓
     * 62@장개시전 시간외대량
     * 63@장개시전 시간외바스켓
     * 67@장개시전 금전신탁자사주
     * 69@장개시전 자기주식
     * 72@시간외대량
     * 77@시간외자사주신탁
     * 79@시간외대량자기주식
     * 80@바스켓
     * 21@중간가
     * 22@스톱지정가
     * 23@중간가IOC
     * 24@중간가FOK
     */
    @Body
    private String ordDvsn = "00";

    /**
     * 주문수량
     *
     * 주문수량
     */
    @Body
    @NonNull
    private String ordQty;

    /**
     * 주문단가
     *
     * 주문단가
     */
    @Body
    @NonNull
    private String ordUnpr;

    /**
     * 조건가격
     *
     * 스탑지정가호가 주문 (ORD_DVSN이 22) 사용 시에만 필수
     */
    @Body
    private String cndtPric = "";

    /**
     * 거래소ID구분코드
     *
     * 한국거래소 : KRX
     * 대체거래소 (넥스트레이드) : NXT
     * → 미입력시 KRX로 진행
     */
    @Body
    private String excgIdDvsnCd = "";

}
