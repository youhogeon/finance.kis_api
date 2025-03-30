package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquireOvertimePriceResult extends CommonRestResult {

    /** 성공 실패 여부 */
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

        /** 업종 한글 종목명 (※ 거래소 정보로 특정 종목은 업종구분이 없어 데이터 미회신) */
        private String bstpKorIsnm;

        /** 관리 종목 구분 명 */
        private String mangIssuClsName;

        /** 시간외 단일가 현재가 */
        private String ovtmUntpPrpr;

        /** 시간외 단일가 전일 대비 */
        private String ovtmUntpPrdyVrss;

        /** 시간외 단일가 전일 대비 부호 */
        private String ovtmUntpPrdyVrssSign;

        /** 시간외 단일가 전일 대비율 */
        private String ovtmUntpPrdyCtrt;

        /** 시간외 단일가 거래량 */
        private String ovtmUntpVol;

        /** 시간외 단일가 거래 대금 */
        private String ovtmUntpTrPbmn;

        /** 시간외 단일가 상한가 */
        private String ovtmUntpMxpr;

        /** 시간외 단일가 하한가 */
        private String ovtmUntpLlam;

        /** 시간외 단일가 시가2 */
        private String ovtmUntpOprc;

        /** 시간외 단일가 최고가 */
        private String ovtmUntpHgpr;

        /** 시간외 단일가 최저가 */
        private String ovtmUntpLwpr;

        /** 증거금 비율 */
        private String margRate;

        /** 시간외 단일가 예상 체결가 */
        private String ovtmUntpAntcCnpr;

        /** 시간외 단일가 예상 체결 대비 */
        private String ovtmUntpAntcCntgVrss;

        /** 시간외 단일가 예상 체결 대비 부호 */
        private String ovtmUntpAntcCntgVrssSign;

        /** 시간외 단일가 예상 체결 대비율 */
        private String ovtmUntpAntcCntgCtrt;

        /** 시간외 단일가 예상 체결량 */
        private String ovtmUntpAntcCnqn;

        /** 신용 가능 여부 */
        private String crdtAbleYn;

        /** 신규 상장 구분 명 */
        private String newLstnClsName;

        /** 정리매매 여부 */
        private String sltrYn;

        /** 관리 종목 여부 */
        private String mangIssuYn;

        /** 시장 경고 구분 코드 */
        private String mrktWarnClsCode;

        /** 거래정지 여부 */
        private String trhtYn;

        /** 임의 매매 구분 명 */
        private String vlntDealClsName;

        /** 시간외 단일가 기준가 */
        private String ovtmUntpSdpr;

        /** 시장 경구 구분 명 */
        private String mrktWarnClsName;

        /** 재평가 종목 사유 명 */
        private String revlIssuReasName;

        /** 불성실 공시 여부 */
        private String insnPbntYn;

        /** 락 구분 이름 */
        private String flngClsName;

        /** 대표 시장 한글 명 */
        private String rprsMrktKorName;

        /** 시간외 단일가 VI 적용 구분 코드 */
        private String ovtmViClsCode;

        /** 매수호가 */
        private String bidp;

        /** 매도호가 */
        private String askp;
    }

}
