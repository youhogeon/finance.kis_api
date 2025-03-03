package com.youhogeon.finance.kis_api.api;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquirePriceResponse extends CommonResponse {

    private String rt_cd;
    private String msg_cd;
    private String msg1;
    private Output output;

    @Getter
    public static class Output {
        private String iscd_stat_cls_code;
        private String marg_rate;
        private String rprs_mrkt_kor_name;
        private String new_hgpr_lwpr_cls_code;
        private String bstp_kor_isnm;
        private String temp_stop_yn;
        private String oprc_rang_cont_yn;
        private String clpr_rang_cont_yn;
        private String crdt_able_yn;
        private String grmn_rate_cls_code;
        private String elw_pblc_yn;
        private String stck_prpr;
        private String prdy_vrss;
        private String prdy_vrss_sign;
        private String prdy_ctrt;
        private String acml_tr_pbmn;
        private String acml_vol;
        private String prdy_vrss_vol_rate;
        private String stck_oprc;
        private String stck_hgpr;
        private String stck_lwpr;
        private String stck_mxpr;
        private String stck_llam;
        private String stck_sdpr;
        private String wghn_avrg_stck_prc;
        private String hts_frgn_ehrt;
        private String frgn_ntby_qty;
        private String pgtr_ntby_qty;
        private String pvt_scnd_dmrs_prc;
        private String pvt_frst_dmrs_prc;
        private String pvt_pont_val;
        private String pvt_frst_dmsp_prc;
        private String pvt_scnd_dmsp_prc;
        private String dmrs_val;
        private String dmsp_val;
        private String cpfn;
        private String rstc_wdth_prc;
        private String stck_fcam;
        private String stck_sspr;
        private String aspr_unit;
        private String hts_deal_qty_unit_val;
        private String lstn_stcn;
        private String hts_avls;
        private String per;
        private String pbr;
        private String stac_month;
        private String vol_tnrt;
        private String eps;
        private String bps;
        private String d250_hgpr;
        private String d250_hgpr_date;
        private String d250_hgpr_vrss_prpr_rate;
        private String d250_lwpr;
        private String d250_lwpr_date;
        private String d250_lwpr_vrss_prpr_rate;
        private String stck_dryy_hgpr;
        private String dryy_hgpr_vrss_prpr_rate;
        private String dryy_hgpr_date;
        private String stck_dryy_lwpr;
        private String dryy_lwpr_vrss_prpr_rate;
        private String dryy_lwpr_date;
        private String w52_hgpr;
        private String w52_hgpr_vrss_prpr_ctrt;
        private String w52_hgpr_date;
        private String w52_lwpr;
        private String w52_lwpr_vrss_prpr_ctrt;
        private String w52_lwpr_date;
        private String whol_loan_rmnd_rate;
        private String ssts_yn;
        private String stck_shrn_iscd;
        private String fcam_cnnm;
        private String cpfn_cnnm;
        private String apprch_rate;
        private String frgn_hldn_qty;
        private String vi_cls_code;
        private String ovtm_vi_cls_code;
        private String last_ssts_cntg_qty;
        private String invt_caful_yn;
        private String mrkt_warn_cls_code;
        private String short_over_yn;
        private String sltr_yn;
        private String mang_issu_cls_code;
    }

}
