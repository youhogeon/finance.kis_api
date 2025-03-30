package com.youhogeon.finance.kis_api.api.rest.deprecated;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireIndexPriceResult extends CommonRestResult {

    private String rtCd;
    private String msgCd;
    private String msg1;
    private Output output;

    @Getter
    @ToString
    public static class Output {
        private String bstpNmixPrpr;
        private String bstpNmixPrdyVrss;
        private String prdyVrssSign;
        private String bstpNmixPrdyCtrt;
        private String acmlVol;
        private String prdyVol;
        private String acmlTrPbmn;
        private String prdyTrPbmn;
        private String bstpNmixOprc;
        private String prdyNmixVrssNmixOprc;
        private String oprcVrssPrprSign;
        private String bstpNmixOprcPrdyCtrt;
        private String bstpNmixHgpr;
        private String prdyNmixVrssNmixHgpr;
        private String hgprVrssPrprSign;
        private String bstpNmixHgprPrdyCtrt;
        private String bstpNmixLwpr;
        private String prdyClprVrssLwpr;
        private String lwprVrssPrprSign;
        private String prdyClprVrssLwprRate;
        private String ascnIssuCnt;
        private String uplmIssuCnt;
        private String stnrIssuCnt;
        private String downIssuCnt;
        private String lslmIssuCnt;
        private String dryyBstpNmixHgpr;
        private String dryyHgprVrssPrprRate;
        private String dryyBstpNmixHgprDate;
        private String dryyBstpNmixLwpr;
        private String dryyLwprVrssPrprRate;
        private String dryyBstpNmixLwprDate;
        private String totalAskpRsqn;
        private String totalBidpRsqn;
        private String selnRsqnRate;
        private String shnuRsqnRate;
        private String ntbyRsqn;
    }

}
