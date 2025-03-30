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
 * 주식주문(정정취소)[v1_국내주식-003]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.POST, path = "/uapi/domestic-stock/v1/trading/order-rvsecncl")
public class OrderRvsecnclApi extends CommonRestApi<OrderRvsecnclResult> {

    @Header
    private String trId = "TTTC0013U";

    /**
     * 한국거래소전송주문조직번호
     */
    @Body
    @NonNull
    private String krxFwdgOrdOrgno;

    /**
     * 원주문번호
     */
    @Body
    @NonNull
    private String orgnOdno;

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
     * 정정취소구분코드
     *
     * 01@정정
     * 02@취소
     */
    @Body
    private String rvseCnclDvsnCd = "01";

    /**
     * 주문수량
     *
     * 주문수량
     */
    @Body
    private String ordQty = "0";

    /**
     * 주문단가
     *
     * 주문단가
     */
    @Body
    private String ordUnpr = "0";

    /**
     * 잔량전부주문여부
     *
     * 'Y@전량
     * N@일부'
     */
    @Body
    private String qtyAllOrdYn = "N";

    /**
     * 조건가격
     *
     * 스탑지정가호가에서 사용
     */
    @Body
    private String cndtPric = "";

    /**
     * 거래소ID구분코드
     *
     * 한국거래소 : KRX
     * 대체거래소 (넥스트레이드) : NXT
     */
    @Body
    private String excgIdDvsnCd = "KRX";

}
