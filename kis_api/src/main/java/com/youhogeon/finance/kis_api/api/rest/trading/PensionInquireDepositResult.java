package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class PensionInquireDepositResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세1 */
    private Output output;

    @Getter
    @ToString
    public static class Output {

        /** 예수금총액 */
        private String dncaTota;

        /** 익일정산액 */
        private String nxdyExccAmt;

        /** 익일결제금액 */
        private String nxdySttlAmt;

        /** 2익일결제금액 */
        private String nx2DaySttlAmt;
    }

}
