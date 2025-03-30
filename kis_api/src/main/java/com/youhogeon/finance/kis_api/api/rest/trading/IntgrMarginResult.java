package com.youhogeon.finance.kis_api.api.rest.trading;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class IntgrMarginResult extends CommonRestResult {

    /** 성공 실패 여부 (0: 성공, 그 외: 실패) */
    private String rtCd;

    /** 응답코드 */
    private String msgCd;

    /** 응답메세지 */
    private String msg1;

    /** 응답상세 */
    private Output1 output1;

    @Getter
    @ToString
    public static class Output1 {

        /** 계좌증거금율 */
        private String acmgaRt;

        /** 계좌증거금100퍼센트지정사유 */
        private String acmgaPct100AptmRson;

        /** 주식현금대상금액 */
        private String stckCashObjtAmt;

        /** 주식대용대상금액 */
        private String stckSbstObjtAmt;

        /** 주식평가대상금액 */
        private String stckEvluObjtAmt;

        /** 주식재사용가능대상금액 */
        private String stckRusePsblObjtAmt;

        /** 주식펀드환매대금대상금액 */
        private String stckFundRpchChgsObjtAmt;

        /** 주식융자상환금대상금액 */
        private String stckFncgRdptObjtAtm;

        /** 채권재사용가능대상금액 */
        private String bondRusePsblObjtAmt;

        /** 주식현금사용금액 */
        private String stckCashUseAmt;

        /** 주식대용사용금액 */
        private String stckSbstUseAmt;

        /** 주식평가사용금액 */
        private String stckEvluUseAmt;

        /** 주식재사용가능금사용금액 */
        private String stckRusePsblAmtUseAmt;

        /** 주식펀드환매대금사용금액 */
        private String stckFundRpchChgsUseAmt;

        /** 주식융자상환금사용금액 */
        private String stckFncgRdptAmtUseAmt;

        /** 채권재사용가능금사용금액 */
        private String bondRusePsblAmtUseAmt;

        /** 주식현금주문가능금액 */
        private String stckCashOrdPsblAmt;

        /** 주식대용주문가능금액 */
        private String stckSbstOrdPsblAmt;

        /** 주식평가주문가능금액 */
        private String stckEvluOrdPsblAmt;

        /** 주식재사용가능주문가능금액 */
        private String stckRusePsblOrdPsblAmt;

        /** 주식펀드환매주문가능금액 */
        private String stckFundRpchOrdPsblAmt;

        /** 채권재사용가능주문가능금액 */
        private String bondRusePsblOrdPsblAmt;

        /** 미수금액 */
        private String rcvbAmt;

        /** 주식대출보증금재사용가능금액 */
        private String stckLoanGrtaRusePsblAmt;

        /** 주식현금20최대주문가능금액 */
        private String stckCash20MaxOrdPsblAmt;

        /** 주식현금30최대주문가능금액 */
        private String stckCash30MaxOrdPsblAmt;

        /** 주식현금40최대주문가능금액 */
        private String stckCash40MaxOrdPsblAmt;

        /** 주식현금50최대주문가능금액 */
        private String stckCash50MaxOrdPsblAmt;

        /** 주식현금60최대주문가능금액 */
        private String stckCash60MaxOrdPsblAmt;

        /** 주식현금100최대주문가능금액 */
        private String stckCash100MaxOrdPsblAmt;

        /** 주식재사용불가100최대주문가능 */
        private String stckRsip100MaxOrdPsblAmt;

        /** 채권최대주문가능금액 */
        private String bondMaxOrdPsblAmt;

        /** 주식융자45최대주문가능금액 */
        private String stckFncg45MaxOrdPsblAmt;

        /** 주식융자50최대주문가능금액 */
        private String stckFncg50MaxOrdPsblAmt;

        /** 주식융자60최대주문가능금액 */
        private String stckFncg60MaxOrdPsblAmt;

        /** 주식융자70최대주문가능금액 */
        private String stckFncg70MaxOrdPsblAmt;

        /** 주식대주최대주문가능금액 */
        private String stckStlnMaxOrdPsblAmt;

        /** 한도금액 */
        private String lmtAmt;

        /** 해외주식통합증거금구분명 */
        private String ovrsStckItgrMgnaDvsnName;

        /** 미화대상금액 */
        private String usdObjtAmt;

        /** 미화사용금액 */
        private String usdUseAmt;

        /** 미화주문가능금액 */
        private String usdOrdPsblAmt;

        /** 홍콩달러대상금액 */
        private String hkdObjtAmt;

        /** 홍콩달러사용금액 */
        private String hkdUseAmt;

        /** 홍콩달러주문가능금액 */
        private String hkdOrdPsblAmt;

        /** 엔화대상금액 */
        private String jpyObjtAmt;

        /** 엔화사용금액 */
        private String jpyUseAmt;

        /** 엔화주문가능금액 */
        private String jpyOrdPsblAmt;

        /** 위안화대상금액 */
        private String cnyObjtAmt;

        /** 위안화사용금액 */
        private String cnyUseAmt;

        /** 위안화주문가능금액 */
        private String cnyOrdPsblAmt;

        /** 미화재사용대상금액 */
        private String usdRuseObjtAmt;

        /** 미화재사용금액 */
        private String usdRuseAmt;

        /** 미화재사용주문가능금액 */
        private String usdRuseOrdPsblAmt;

        /** 홍콩달러재사용대상금액 */
        private String hkdRuseObjtAmt;

        /** 홍콩달러재사용금액 */
        private String hkdRuseAmt;

        /** 홍콩달러재사용주문가능금액 */
        private String hkdRuseOrdPsblAmt;

        /** 엔화재사용대상금액 */
        private String jpyRuseObjtAmt;

        /** 엔화재사용금액 */
        private String jpyRuseAmt;

        /** 엔화재사용주문가능금액 */
        private String jpyRuseOrdPsblAmt;

        /** 위안화재사용대상금액 */
        private String cnyRuseObjtAmt;

        /** 위안화재사용금액 */
        private String cnyRuseAmt;

        /** 위안화재사용주문가능금액 */
        private String cnyRuseOrdPsblAmt;

        /** 미화일반주문가능금액 */
        private String usdGnrlOrdPsblAmt;

        /** 미화통합주문가능금액 */
        private String usdItgrOrdPsblAmt;

        /** 홍콩달러일반주문가능금액 */
        private String hkdGnrlOrdPsblAmt;

        /** 홍콩달러통합주문가능금액 */
        private String hkdItgrOrdPsblAmt;

        /** 엔화일반주문가능금액 */
        private String jpyGnrlOrdPsblAmt;

        /** 엔화통합주문가능금액 */
        private String jpyItgrOrdPsblAmt;

        /** 위안화일반주문가능금액 */
        private String cnyGnrlOrdPsblAmt;

        /** 위안화통합주문가능금액 */
        private String cnyItgrOrdPsblAmt;

        /** 주식통합현금20주문가능금액 */
        private String stckItgrCash20OrdPsblAmt;

        /** 주식통합현금30주문가능금액 */
        private String stckItgrCash30OrdPsblAmt;

        /** 주식통합현금40주문가능금액 */
        private String stckItgrCash40OrdPsblAmt;

        /** 주식통합현금50주문가능금액 */
        private String stckItgrCash50OrdPsblAmt;

        /** 주식통합현금60주문가능금액 */
        private String stckItgrCash60OrdPsblAmt;

        /** 주식통합현금100주문가능금액 */
        private String stckItgrCash100OrdPsblAmt;

        /** 주식통합100주문가능금액 */
        private String stckItgr100OrdPsblAmt;

        /** 주식통합융자45주문가능금액 */
        private String stckItgrFncg45OrdPsblAmt;

        /** 주식통합융자50주문가능금액 */
        private String stckItgrFncg50OrdPsblAmt;

        /** 주식통합융자60주문가능금액 */
        private String stckItgrFncg60OrdPsblAmt;

        /** 주식통합융자70주문가능금액 */
        private String stckItgrFncg70OrdPsblAmt;

        /** 주식통합대주주문가능금액 */
        private String stckItgrStlnOrdPsblAmt;

        /** 채권통합주문가능금액 */
        private String bondItgrOrdPsblAmt;

        /** 주식현금해외사용금액 */
        private String stckCashOvrsUseAmt;

        /** 주식대용해외사용금액 */
        private String stckSbstOvrsUseAmt;

        /** 주식평가해외사용금액 */
        private String stckEvluOvrsUseAmt;

        /** 주식재사용금액해외사용금액 */
        private String stckReUseAmtOvrsUseAmt;

        /** 주식펀드환매해외사용금액 */
        private String stckFundRpchOvrsUseAmt;

        /** 주식융자상환해외사용금액 */
        private String stckFncgRdptOvrsUseAmt;

        /** 채권재사용해외사용금액 */
        private String bondReUseOvrsUseAmt;

        /** 미화타시장사용금액 */
        private String usdOthMketUseAmt;

        /** 엔화타시장사용금액 */
        private String jpyOthMketUseAmt;

        /** 위안화타시장사용금액 */
        private String cnyOthMketUseAmt;

        /** 홍콩달러타시장사용금액 */
        private String hkdOthMketUseAmt;

        /** 미화재사용타시장사용금액 */
        private String usdReUseOthMketUseAmt;

        /** 엔화재사용타시장사용금액 */
        private String jpyReUseOthMketUseAmt;

        /** 위안화재사용타시장사용금액 */
        private String cnyReUseOthMketUseAmt;

        /** 홍콩달러재사용타시장사용금액 */
        private String hkdReUseOthMketUseAmt;

        /** 홍콩위안화재사용금액 */
        private String hgkgCnyReUseAmt;

    }

}
