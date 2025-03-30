package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireOvertimeAskingPriceResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output output;

    @Getter
    @ToString
    public static class Output {

        /** 시간외 단일가 최종 시간 */
        private String ovtmUntpLastHour;

        /** 시간외 단일가 매도호가1~10 */
        private String ovtmUntpAskp1;
        private String ovtmUntpAskp2;
        private String ovtmUntpAskp3;
        private String ovtmUntpAskp4;
        private String ovtmUntpAskp5;
        private String ovtmUntpAskp6;
        private String ovtmUntpAskp7;
        private String ovtmUntpAskp8;
        private String ovtmUntpAskp9;
        private String ovtmUntpAskp10;

        /** 시간외 단일가 매수호가1~10 */
        private String ovtmUntpBidp1;
        private String ovtmUntpBidp2;
        private String ovtmUntpBidp3;
        private String ovtmUntpBidp4;
        private String ovtmUntpBidp5;
        private String ovtmUntpBidp6;
        private String ovtmUntpBidp7;
        private String ovtmUntpBidp8;
        private String ovtmUntpBidp9;
        private String ovtmUntpBidp10;

        /** 시간외 단일가 매도호가 증감1~10 */
        private String ovtmUntpAskpIcdc1;
        private String ovtmUntpAskpIcdc2;
        private String ovtmUntpAskpIcdc3;
        private String ovtmUntpAskpIcdc4;
        private String ovtmUntpAskpIcdc5;
        private String ovtmUntpAskpIcdc6;
        private String ovtmUntpAskpIcdc7;
        private String ovtmUntpAskpIcdc8;
        private String ovtmUntpAskpIcdc9;
        private String ovtmUntpAskpIcdc10;

        /** 시간외 단일가 매수호가 증감1~10 */
        private String ovtmUntpBidpIcdc1;
        private String ovtmUntpBidpIcdc2;
        private String ovtmUntpBidpIcdc3;
        private String ovtmUntpBidpIcdc4;
        private String ovtmUntpBidpIcdc5;
        private String ovtmUntpBidpIcdc6;
        private String ovtmUntpBidpIcdc7;
        private String ovtmUntpBidpIcdc8;
        private String ovtmUntpBidpIcdc9;
        private String ovtmUntpBidpIcdc10;

        /** 시간외 단일가 매도호가 잔량1~10 */
        private String ovtmUntpAskpRsqn1;
        private String ovtmUntpAskpRsqn2;
        private String ovtmUntpAskpRsqn3;
        private String ovtmUntpAskpRsqn4;
        private String ovtmUntpAskpRsqn5;
        private String ovtmUntpAskpRsqn6;
        private String ovtmUntpAskpRsqn7;
        private String ovtmUntpAskpRsqn8;
        private String ovtmUntpAskpRsqn9;
        private String ovtmUntpAskpRsqn10;

        /** 시간외 단일가 매수호가 잔량1~10 */
        private String ovtmUntpBidpRsqn1;
        private String ovtmUntpBidpRsqn2;
        private String ovtmUntpBidpRsqn3;
        private String ovtmUntpBidpRsqn4;
        private String ovtmUntpBidpRsqn5;
        private String ovtmUntpBidpRsqn6;
        private String ovtmUntpBidpRsqn7;
        private String ovtmUntpBidpRsqn8;
        private String ovtmUntpBidpRsqn9;
        private String ovtmUntpBidpRsqn10;

        /** 시간외 단일가 총 매도호가 잔량 */
        private String ovtmUntpTotalAskpRsqn;

        /** 시간외 단일가 총 매수호가 잔량 */
        private String ovtmUntpTotalBidpRsqn;

        /** 시간외 단일가 총 매도호가 잔량 증감 */
        private String ovtmUntpTotalAskpRsqnIcdc;

        /** 시간외 단일가 총 매수호가 잔량 증감 */
        private String ovtmUntpTotalBidpRsqnIcdc;

        /** 시간외 단일가 순매수 호가 잔량 */
        private String ovtmUntpNtbyBidpRsqn;

        /** 총 매도호가 잔량 */
        private String totalAskpRsqn;

        /** 총 매수호가 잔량 */
        private String totalBidpRsqn;

        /** 총 매도호가 잔량 증감 */
        private String totalAskpRsqnIcdc;

        /** 총 매수호가 잔량 증감 */
        private String totalBidpRsqnIcdc;

        /** 시간외 총 매도호가 잔량 */
        private String ovtmTotalAskpRsqn;

        /** 시간외 총 매수호가 잔량 */
        private String ovtmTotalBidpRsqn;

        /** 시간외 총 매도호가 증감 */
        private String ovtmTotalAskpIcdc;

        /** 시간외 총 매수호가 증감 */
        private String ovtmTotalBidpIcdc;
    }

}
