package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireAskingPriceExpCcnResult extends CommonRestResult {

    /** 성공 실패 여부 */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output1 output1;

    /** 응답상세2 */
    private Output2 output2;

    @Getter
    @ToString
    public static class Output1 {

        /** 호가 접수 시간 */
        private String asprAcptHour;

        /** 매도호가1 */
        private String askp1;

        /** 매도호가2 */
        private String askp2;

        /** 매도호가3 */
        private String askp3;

        /** 매도호가4 */
        private String askp4;

        /** 매도호가5 */
        private String askp5;

        /** 매도호가6 */
        private String askp6;

        /** 매도호가7 */
        private String askp7;

        /** 매도호가8 */
        private String askp8;

        /** 매도호가9 */
        private String askp9;

        /** 매도호가10 */
        private String askp10;

        /** 매수호가1 */
        private String bidp1;

        /** 매수호가2 */
        private String bidp2;

        /** 매수호가3 */
        private String bidp3;

        /** 매수호가4 */
        private String bidp4;

        /** 매수호가5 */
        private String bidp5;

        /** 매수호가6 */
        private String bidp6;

        /** 매수호가7 */
        private String bidp7;

        /** 매수호가8 */
        private String bidp8;

        /** 매수호가9 */
        private String bidp9;

        /** 매수호가10 */
        private String bidp10;

        /** 매도호가 잔량1 */
        private String askpRsqn1;

        /** 매도호가 잔량2 */
        private String askpRsqn2;

        /** 매도호가 잔량3 */
        private String askpRsqn3;

        /** 매도호가 잔량4 */
        private String askpRsqn4;

        /** 매도호가 잔량5 */
        private String askpRsqn5;

        /** 매도호가 잔량6 */
        private String askpRsqn6;

        /** 매도호가 잔량7 */
        private String askpRsqn7;

        /** 매도호가 잔량8 */
        private String askpRsqn8;

        /** 매도호가 잔량9 */
        private String askpRsqn9;

        /** 매도호가 잔량10 */
        private String askpRsqn10;

        /** 매수호가 잔량1 */
        private String bidpRsqn1;

        /** 매수호가 잔량2 */
        private String bidpRsqn2;

        /** 매수호가 잔량3 */
        private String bidpRsqn3;

        /** 매수호가 잔량4 */
        private String bidpRsqn4;

        /** 매수호가 잔량5 */
        private String bidpRsqn5;

        /** 매수호가 잔량6 */
        private String bidpRsqn6;

        /** 매수호가 잔량7 */
        private String bidpRsqn7;

        /** 매수호가 잔량8 */
        private String bidpRsqn8;

        /** 매수호가 잔량9 */
        private String bidpRsqn9;

        /** 매수호가 잔량10 */
        private String bidpRsqn10;

        /** 매도호가 잔량 증감1 */
        private String askpRsqnIcdc1;

        /** 매도호가 잔량 증감2 */
        private String askpRsqnIcdc2;

        /** 매도호가 잔량 증감3 */
        private String askpRsqnIcdc3;

        /** 매도호가 잔량 증감4 */
        private String askpRsqnIcdc4;

        /** 매도호가 잔량 증감5 */
        private String askpRsqnIcdc5;

        /** 매도호가 잔량 증감6 */
        private String askpRsqnIcdc6;

        /** 매도호가 잔량 증감7 */
        private String askpRsqnIcdc7;

        /** 매도호가 잔량 증감8 */
        private String askpRsqnIcdc8;

        /** 매도호가 잔량 증감9 */
        private String askpRsqnIcdc9;

        /** 매도호가 잔량 증감10 */
        private String askpRsqnIcdc10;

        /** 매수호가 잔량 증감1 */
        private String bidpRsqnIcdc1;

        /** 매수호가 잔량 증감2 */
        private String bidpRsqnIcdc2;

        /** 매수호가 잔량 증감3 */
        private String bidpRsqnIcdc3;

        /** 매수호가 잔량 증감4 */
        private String bidpRsqnIcdc4;

        /** 매수호가 잔량 증감5 */
        private String bidpRsqnIcdc5;

        /** 매수호가 잔량 증감6 */
        private String bidpRsqnIcdc6;

        /** 매수호가 잔량 증감7 */
        private String bidpRsqnIcdc7;

        /** 매수호가 잔량 증감8 */
        private String bidpRsqnIcdc8;

        /** 매수호가 잔량 증감9 */
        private String bidpRsqnIcdc9;

        /** 매수호가 잔량 증감10 */
        private String bidpRsqnIcdc10;

        /** 총 매도호가 잔량 */
        private String totalAskpRsqn;

        /** 총 매수호가 잔량 */
        private String totalBidpRsqn;

        /** 신 장운영 구분 코드 ('00': 장전 예상체결가와 장마감 동시호가, '49': 장후 예상체결가 등) */
        private String newMkopClsCode;

        /** 총 매도호가 잔량 증감 */
        private String totalAskpRsqnIcdc;

        /** 총 매수호가 잔량 증감 */
        private String totalBidpRsqnIcdc;

        /** 시간외 총 매도호가 증감 */
        private String ovtmTotalAskpIcdc;

        /** 시간외 총 매수호가 증감 */
        private String ovtmTotalBidpIcdc;

        /** 시간외 총 매도호가 잔량 */
        private String ovtmTotalAskpRsqn;

        /** 시간외 총 매수호가 잔량 */
        private String ovtmTotalBidpRsqn;

        /** 순매수 호가 잔량 */
        private String ntbyAsprRsqn;

    }

    @Getter
    @ToString
    public static class Output2 {

        /** 예상 장운영 구분 코드 */
        private String antcMkopClsCode;

        /** 주식 현재가 */
        private String stckPrpr;

        /** 주식 시가2 */
        private String stckOprc;

        /** 주식 최고가 */
        private String stckHgpr;

        /** 주식 최저가 */
        private String stckLwpr;

        /** 주식 기준가 */
        private String stckSdpr;

        /** 예상 체결가 */
        private String antcCnpr;

        /** 예상 체결 대비 부호 */
        private String antcCntgVrssSign;

        /** 예상 체결 대비 */
        private String antcCntgVrss;

        /** 예상 체결 전일 대비율 */
        private String antcCntgPrdyCtrt;

        /** 예상 거래량 */
        private String antcVol;

        /** 주식 단축 종목코드 */
        private String stckShrnIscd;

        /** VI적용구분코드 */
        private String viClsCode;
    }


}
