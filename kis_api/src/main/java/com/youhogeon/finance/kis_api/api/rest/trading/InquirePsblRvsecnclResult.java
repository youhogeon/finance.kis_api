package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonPageableRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquirePsblRvsecnclResult extends CommonPageableRestResult<InquirePsblRvsecnclResult> {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 배열 */
    private Output[] output;

    @Getter
    @ToString
    public static class Output {

        /** 주문채번지점번호 (주문시 한국투자증권 시스템에서 지정된 영업점코드) */
        private String ordGnoBrno;

        /** 주문번호 (주문시 한국투자증권 시스템에서 채번된 주문번호) */
        private String odno;

        /** 원주문번호 (정정/취소주문인 경우 원주문번호) */
        private String orgnOdno;

        /** 주문구분명 */
        private String ordDvsnName;

        /** 상품번호 (종목번호(뒤 6자리만 해당)) */
        private String pdno;

        /** 상품명 (종목명) */
        private String prdtName;

        /** 정정취소구분명 (정정 또는 취소 여부 표시) */
        private String rvseCnclDvsnName;

        /** 주문수량 */
        private String ordQty;

        /** 주문단가 (1주당 주문가격) */
        private String ordUnpr;

        /** 주문시각 (주문시각(시분초HHMMSS)) */
        private String ordTmd;

        /** 총체결수량 (주문 수량 중 체결된 수량) */
        private String totCcldQty;

        /** 총체결금액 (주문금액 중 체결금액) */
        private String totCcldAmt;

        /** 가능수량 (정정/취소 주문 가능 수량) */
        private String psblQty;

        /** 매도매수구분코드 (01:매도, 02:매수) */
        private String sllBuyDvsnCd;

        /**
         * 주문구분코드
         * 00:지정가, 01:시장가, 02:조건부지정가, 03:최유리지정가, 04:최우선지정가,
         * 05:장전시간외, 06:장후시간외, 07:시간외단일가, 08:자기주식, 09:자기주식S-Option,
         * 10:자기주식금전신탁, 11:IOC지정가, 12:FOK지정가, 13:IOC시장가, 14:FOK시장가,
         * 15:IOC최유리, 16:FOK최유리, 51:장중대량
         */
        private String ordDvsnCd;

        /** 운용사지정주문번호 */
        private String mgcoAptmOdno;

        /** 거래소구분코드 */
        private String excgDvsnCd;

        /** 거래소ID구분코드 */
        private String excgIdDvsnCd;

        /** 거래소ID구분명 */
        private String excgIdDvsnName;

        /** 스톱지정가조건가격 */
        private String stpmCndtPric;

        /** 스톱지정가효력발생여부 */
        private String stpmEfctOccrYn;
    }

}
