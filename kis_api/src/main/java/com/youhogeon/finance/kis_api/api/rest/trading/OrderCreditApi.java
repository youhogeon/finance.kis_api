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
 * 주식주문(신용)[v1_국내주식-002]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@AccountRequired
@RestApi(method = RestApi.Method.POST, path = "/uapi/domestic-stock/v1/trading/order-credit")
public class OrderCreditApi extends CommonRestApi<OrderCreditResult> {

    /**
     * 매도 : TTTC0051U
     * 매수 : TTTC0052U
     * '
     */
    @Header
    private String trId = "TTTC0052U";

    /**
     * 상품번호
     *
     *  종목코드(6자리)
     */
    @Body
    @NonNull
    private String pdno;

    /**
     * 매도유형
     *
     * 공란 입력
     */
    @Body
    private String sllType = "";

    /**
     * 신용유형
     *
     * [매도] 22 : 유통대주신규, 24 : 자기대주신규, 25 : 자기융자상환, 27 : 유통융자상환
     * [매수] 21 : 자기융자신규, 23 : 유통융자신규 , 26 : 유통대주상환, 28 : 자기대주상환
     */
    @Body
    private String crdtType = "21";

    /**
     * 대출일자
     *
     *  [신용매수]
     * 신규 대출로, 오늘날짜(yyyyMMdd)) 입력
     *
     * [신용매도]
     * 매도할 종목의 대출일자(yyyyMMdd)) 입력
     */
    @Body
    @NonNull
    private String loanDt;

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
     *
     */
    @Body
    @NonNull
    private String ordQty;

    /**
     * 주문단가
     *
     *  1주당 가격
     * * 장전 시간외, 장후 시간외, 시장가의 경우 1주당 가격을 공란으로 비우지 않음 "0"으로 입력 권고
     */
    @Body
    @NonNull
    private String ordUnpr;

    /**
     * 예약주문여부
     *
     *  정규 증권시장이 열리지 않는 시간 (15:10분 ~ 익일 7:30분) 에 주문을 미리 설정 하여 다음 영업일 또는 설정한 기간 동안 아침 동시 호가에 주문하는 것
     * Y : 예약주문
     * N : 신용주문
     */
    @Body
    private String rsvnOrdYn = "N";

    /**
     * 비상주문여부
     *
     *
     */
    @Body
    private String emgcOrdYn = "";

    /**
     * 프로그램매매구분
     *
     *
     */
    @Body
    private String pgtrDvsn = "";

    /**
     * 운용사지정주문번호
     *
     *
     */
    @Body
    private String mgcoAptmOdno = "";

    /**
     * 대량거래협상상세번호
     *
     *
     */
    @Body
    private String lqtyTrNgtnDtlNo = "";

    /**
     * 대량거래협정번호
     *
     *
     */
    @Body
    private String lqtyTrAgmtNo = "";

    /**
     * 대량거래협상자Id
     *
     *
     */
    @Body
    private String lqtyTrNgtnId = "";

    /**
     * LP주문여부
     *
     *
     */
    @Body
    private String lpOrdYn = "";

    /**
     * 매체주문번호
     *
     *
     */
    @Body
    private String mdiaOdno = "";

    /**
     * 주문서버구분코드
     *
     *
     */
    @Body
    private String ordSvrDvsnCd = "";

    /**
     * 프로그램호가신고구분코드
     *
     *
     */
    @Body
    private String pgmNmprStmtDvsnCd = "";

    /**
     * 반대매매선정사유코드
     *
     *
     */
    @Body
    private String cvrgSlctRsonCd = "";

    /**
     * 반대매매순번
     *
     *
     */
    @Body
    private String cvrgSeq = "";

    /**
     * 거래소ID구분코드
     *
     * 한국거래소 : KRX
     * 대체거래소 (넥스트레이드) : NXT
     */
    @Body
    private String excgIdDvsnCd = "KRX";

    /**
     * 조건가격
     *
     * 스탑지정가호가에서 사용
     */
    @Body
    private String cndtPric = "";

}
