package com.youhogeon.finance.kis_api.api.rest;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireAskingPriceExpCcnResult extends CommonRestResult {

    private String rtCd;
    private String msgCd;
    private String msg1;
    private Output1 output1;
    private Output2 output2;

    @Getter
    @ToString
    public static class Output1 {
        private String asprAcptHour;
        private String askp1;
        private String askp2;
        private String askp3;
        private String askp4;
        private String askp5;
        private String askp6;
        private String askp7;
        private String askp8;
        private String askp9;
        private String askp10;
        private String bidp1;
        private String bidp2;
        private String bidp3;
        private String bidp4;
        private String bidp5;
        private String bidp6;
        private String bidp7;
        private String bidp8;
        private String bidp9;
        private String bidp10;
        private String askpRsqn1;
        private String askpRsqn2;
        private String askpRsqn3;
        private String askpRsqn4;
        private String askpRsqn5;
        private String askpRsqn6;
        private String askpRsqn7;
        private String askpRsqn8;
        private String askpRsqn9;
        private String askpRsqn10;
        private String bidpRsqn1;
        private String bidpRsqn2;
        private String bidpRsqn3;
        private String bidpRsqn4;
        private String bidpRsqn5;
        private String bidpRsqn6;
        private String bidpRsqn7;
        private String bidpRsqn8;
        private String bidpRsqn9;
        private String bidpRsqn10;
        private String askpRsqnIcdc1;
        private String askpRsqnIcdc2;
        private String askpRsqnIcdc3;
        private String askpRsqnIcdc4;
        private String askpRsqnIcdc5;
        private String askpRsqnIcdc6;
        private String askpRsqnIcdc7;
        private String askpRsqnIcdc8;
        private String askpRsqnIcdc9;
        private String askpRsqnIcdc10;
        private String bidpRsqnIcdc1;
        private String bidpRsqnIcdc2;
        private String bidpRsqnIcdc3;
        private String bidpRsqnIcdc4;
        private String bidpRsqnIcdc5;
        private String bidpRsqnIcdc6;
        private String bidpRsqnIcdc7;
        private String bidpRsqnIcdc8;
        private String bidpRsqnIcdc9;
        private String bidpRsqnIcdc10;
        private String totalAskpRsqn;
        private String totalBidpRsqn;
        private String totalAskpRsqnIcdc;
        private String totalBidpRsqnIcdc;
        private String ovtmTotalAskpIcdc;
        private String ovtmTotalBidpIcdc;
        private String ovtmTotalAskpRsqn;
        private String ovtmTotalBidpRsqn;
        private String ntbyAsprRsqn;
        private String newMkopClsCode;
    }

    @Getter
    @ToString
    public static class Output2 {
        private String antcMkopClsCode;
        private String stckPrpr;
        private String stckOprc;
        private String stckHgpr;
        private String stckLwpr;
        private String stckSdpr;
        private String antcCnpr;
        private String antcCntgVrssSign;
        private String antcCntgVrss;
        private String antcCntgPrdyCtrt;
        private String antcVol;
        private String stckShrnIscd;
        private String viClsCode;
    }

}
