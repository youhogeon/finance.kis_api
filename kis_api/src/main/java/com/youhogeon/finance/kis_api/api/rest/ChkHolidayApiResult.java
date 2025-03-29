package com.youhogeon.finance.kis_api.api.rest;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ChkHolidayApiResult extends PageableApiResult<ChkHolidayApiResult> {

    private String rtCd;
    private String msgCd;
    private String msg1;
    private Output[] output;

    @Getter
    @ToString
    public static class Output {
        private String bassDt;
        private String wdayDvsnCd;
        private String bzdyYn;
        private String trDayYn;
        private String opndYn;
        private String sttlDayYn;
    }

}
