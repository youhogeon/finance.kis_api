package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonPageableRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class OrderResvCcnlResult extends CommonPageableRestResult<OrderResvCcnlResult> {

    /** 성공 실패 여부 (0: 성공, 0 이외의 값: 실패) */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output[] output;

    @Getter
    @ToString
    public static class Output {

        /** 예약주문 순번 */
        private String rsvnOrdSeq;

        /** 예약주문주문일자 */
        private String rsvnOrdOrdDt;

        /** 예약주문접수일자 */
        private String rsvnOrdRcitDt;

        /** 상품번호 */
        private String pdno;

        /** 주문구분코드 */
        private String ordDvsnCd;

        /** 주문예약수량 */
        private String ordRsvnQty;

        /** 총체결수량 */
        private String totCcldQty;

        /** 취소주문일자 */
        private String cnclOrdDt;

        /** 주문시각 */
        private String ordTmd;

        /** 연락전화번호 */
        private String ctacTlno;

        /** 거부사유2 */
        private String rjctRson2;

        /** 주문번호 */
        private String odno;

        /** 예약주문접수시각 */
        private String rsvnOrdRcitTmd;

        /** 한글종목단축명 */
        private String korItemShtnName;

        /** 매도매수구분코드 */
        private String sllBuyDvsnCd;

        /** 주문예약단가 */
        private String ordRsvnUnpr;

        /** 총체결금액 */
        private String totCcldAmt;

        /** 대출일자 */
        private String loanDt;

        /** 취소접수시각 */
        private String cnclRcitTmd;

        /** 처리결과 */
        private String prcsRslt;

        /** 주문구분명 */
        private String ordDvsnName;

        /** 단말매체종류코드 */
        private String tmnlMdiaKindCd;

        /** 예약종료일자 */
        private String rsvnEndDt;
    }

}
