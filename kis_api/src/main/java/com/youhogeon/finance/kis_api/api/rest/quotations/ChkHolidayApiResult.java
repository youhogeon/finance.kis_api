package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.rest.PageableApiResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ChkHolidayApiResult extends PageableApiResult<ChkHolidayApiResult> {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세1 */
    private Output[] output;

    @Getter
    @ToString
    public static class Output {

        /** 기준일자 (YYYYMMDD) */
        private String bassDt;

        /** 요일구분코드 (01:일요일 ~ 07:토요일) */
        private String wdayDvsnCd;

        /** 영업일여부 (금융기관이 업무를 하는 날, Y/N) */
        private String bzdyYn;

        /** 거래일여부 (입출금, 이체 등 증권업무 가능 여부, Y/N) */
        private String trDayYn;

        /** 개장일여부 (주식시장이 개장되는 날, 주문 시 참고, Y/N) */
        private String opndYn;

        /** 결제일여부 (주식 거래에서 실제 결제가 이루어지는 날, Y/N) */
        private String sttlDayYn;
    }

}
