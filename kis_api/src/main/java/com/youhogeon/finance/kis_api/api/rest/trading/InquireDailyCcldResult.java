package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonPageableRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireDailyCcldResult extends CommonPageableRestResult<InquireDailyCcldResult> {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 (배열) */
    private Output1[] output1;

    /** 응답상세 (단건) */
    private Output2 output2;

    @Getter
    @ToString
    public static class Output1 {

        /** 주문일자 */
        private String ordDt;

        /** 주문채번지점번호 */
        private String ordGnoBrno;

        /** 주문번호 */
        private String odno;

        /** 원주문번호 */
        private String orgnOdno;

        /** 주문구분명 */
        private String ordDvsnName;

        /** 매도매수구분코드 */
        private String sllBuyDvsnCd;

        /** 매도매수구분코드명 */
        private String sllBuyDvsnCdName;

        /** 상품번호 */
        private String pdno;

        /** 상품명 */
        private String prdtName;

        /** 주문수량 */
        private String ordQty;

        /** 주문단가 */
        private String ordUnpr;

        /** 주문시각 */
        private String ordTmd;

        /** 총체결수량 */
        private String totCcldQty;

        /** 평균가 */
        private String avgPrvs;

        /** 취소여부 */
        private String cnclYn;

        /** 총체결금액 */
        private String totCcldAmt;

        /** 대출일자 */
        private String loanDt;

        /** 주문자사번 */
        private String ordrEmpno;

        /** 주문구분코드 */
        private String ordDvsnCd;

        /** 취소확인수량 */
        private String cncCfrmQty;

        /** 잔여수량 */
        private String rmnQty;

        /** 거부수량 */
        private String rjctQty;

        /** 체결조건명 */
        private String ccldCndtName;

        /** 조회IP주소 */
        private String inqrIpAddr;

        /** 전산주문표주문접수구분코드 */
        private String cpbcOrdpOrdRcitDvsnCd;

        /** 전산주문표통보방법구분코드 */
        private String cpbcOrdpInfmMthdDvsnCd;

        /** 통보시각 */
        private String infmTmd;

        /** 연락전화번호 */
        private String ctacTlno;

        /** 상품유형코드 */
        private String prdtTypeCd;

        /** 거래소구분코드 */
        private String excgDvsnCd;

        /** 전산주문표자료구분코드 */
        private String cpbcOrdpMtrlDvsnCd;

        /** 주문조직번호 */
        private String ordOrgno;

        /** 예약주문종료일자 */
        private String rsvnOrdEndDt;

        /** 거래소ID구분코드 */
        private String excgIdDvsnCd;

        /** 스톱지정가조건가격 */
        private String stpmCndtPric;

        /** 스톱지정가효력발생상세시각 */
        private String stpmEfctOccrDtmd;
    }

    @Getter
    @ToString
    public static class Output2 {

        /** 총주문수량 */
        private String totOrdQty;

        /** 총체결수량 */
        private String totCcldQty;

        /** 매입평균가격 */
        private String totCcldAmt;

        /** 총체결금액 */
        private String prsmTlexSmtl;

        /** 추정제비용합계 */
        private String pchsAvgPric;
    }

}
