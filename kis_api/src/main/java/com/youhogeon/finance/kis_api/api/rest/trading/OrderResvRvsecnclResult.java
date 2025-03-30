package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class OrderResvRvsecnclResult extends CommonRestResult {

    /** 성공 실패 여부 (0: 성공, 0 이외의 값: 실패) */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg;

    /** 응답상세 */
    private Output output;

    @Getter
    @ToString
    public static class Output {

        /** 정상처리여부 */
        private String nrmlPrcsYn;
    }

}
