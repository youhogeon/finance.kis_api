package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonPageableRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class PeriodRightsResult extends CommonPageableRestResult<PeriodRightsResult> {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output1[] output1;

    @Getter
    @ToString
    public static class Output1 {

        /** 계좌번호10 */
        private String acno10;

        /**
         * 권리유형코드
         * 1 유상, 2 무상, 3 배당, 4 매수청구, 5 공개매수, 6 주주총회,
         * 7 신주인수권증서, 8 반대의사, 9 신주인수권증권,
         * 11 합병, 12 회사분할, 13 주식교환, 14 액면분할, 15 액면병합,
         * 16 종목변경, 17 감자, 18 신구주합병, 21 후합병,
         * (이하 생략)
         */
        private String rghtTypeCd;

        /** 기준일자 */
        private String bassDt;

        /**
         * 권리잔고유형코드
         * 1 입고, 2 출고, 3 출고입고, 4 출고입금,
         * (이하 생략)
         */
        private String rghtCblcTypeCd;

        /** 대표상품번호 */
        private String rpttPdno;

        /** 상품번호 */
        private String pdno;

        /** 상품유형코드 */
        private String prdtTypeCd;

        /** 단축상품번호 */
        private String shtnPdno;

        /** 상품명 */
        private String prdtName;

        /** 잔고수량 */
        private String cblcQty;

        /** 최종배정수량 */
        private String lastAlctQty;

        /** 초과배정수량 */
        private String excsAlctQty;

        /** 총배정수량 */
        private String totAlctQty;

        /** 최종단수주수량 */
        private String lastFtskQty;

        /** 최종배정금액 */
        private String lastAlctAmt;

        /** 최종단수주대금 */
        private String lastFtskChgs;

        /** 상환원금 */
        private String rdptPrca;

        /** 지연이자금액 */
        private String dlayIntAmt;

        /** 상장일자 */
        private String lstgDt;

        /** 청약종료일자 */
        private String sbscEndDt;

        /** 현금지급일자 */
        private String cashDfrmDt;

        /** 신청수량 */
        private String rqstQty;

        /** 신청금액 */
        private String rqstAmt;

        /** 신청일자 */
        private String rqstDt;

        /** 환불일자 */
        private String rfndDt;

        /** 환불금액 */
        private String rfndAmt;

        /** 상장주수 */
        private String lstgStqt;

        /** 세금금액 */
        private String taxAmt;

        /** 청약단가 */
        private String sbscUnpr;
    }

}
