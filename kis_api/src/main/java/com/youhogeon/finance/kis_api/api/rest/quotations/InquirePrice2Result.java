package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquirePrice2Result extends CommonRestResult {

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

        /** 대표 시장 한글 명 */
        private String rprsMrktKorName;

        /** 신 고가 저가 구분 코드 (특정 경우에만 데이터 출력) */
        private String newHgprLwprClsCode;

        /** 상하한가 구분 코드 (특정 경우에만 데이터 출력) */
        private String mxprLlamClsCode;

        /** 신용 가능 여부 */
        private String crdtAbleYn;

        /** 주식 상한가 */
        private String stckMxpr;

        /** ELW 발행 여부 */
        private String elwPblcYn;

        /** 전일 종가 대비 시가2 비율 */
        private String prdyClprVrssOprcRate;

        /** 신용 비율 */
        private String crdtRate;

        /** 증거금 비율 */
        private String margRate;

        /** 최저가 대비 현재가 */
        private String lwprVrssPrpr;

        /** 최저가 대비 현재가 부호 */
        private String lwprVrssPrprSign;

        /** 전일 종가 대비 최저가 비율 */
        private String prdyClprVrssLwprRate;

        /** 주식 최저가 */
        private String stckLwpr;

        /** 최고가 대비 현재가 */
        private String hgprVrssPrpr;

        /** 최고가 대비 현재가 부호 */
        private String hgprVrssPrprSign;

        /** 전일 종가 대비 최고가 비율 */
        private String prdyClprVrssHgprRate;

        /** 주식 최고가 */
        private String stckHgpr;

        /** 시가2 대비 현재가 */
        private String oprcVrssPrpr;

        /** 시가2 대비 현재가 부호 */
        private String oprcVrssPrprSign;

        /** 관리 종목 여부 */
        private String mangIssuYn;

        /**
         * 동시호가배분처리코드
         * 11: 매수상한배분, 12: 매수하한배분,
         * 13: 매도상한배분, 14: 매도하한배분
         */
        private String diviAppClsCode;

        /** 단기과열여부 */
        private String shortOverYn;

        /**
         * 시장경고코드
         * 00: 없음, 01: 투자주의,
         * 02: 투자경고, 03: 투자위험
         */
        private String mrktWarnClsCode;

        /** 투자유의여부 */
        private String invtCafulYn;

        /** 이상급등여부 */
        private String stangeRunupYn;

        /** 공매도과열 여부 */
        private String sstsHotYn;

        /** 저유동성 종목 여부 */
        private String lowCurrentYn;

        /** VI적용구분코드 */
        private String viClsCode;

        /** 단기과열구분코드 */
        private String shortOverClsCode;

        /** 주식 하한가 */
        private String stckLlam;

        /** 신규 상장 구분 명 */
        private String newLstnClsName;

        /** 임의 매매 구분 명 */
        private String vlntDealClsName;

        /** 락 구분 이름 (특정 경우에만 데이터 출력) */
        private String flngClsName;

        /** 재평가 종목 사유 명 (특정 경우에만 데이터 출력) */
        private String revlIssuReasName;

        /** 시장 경고 구분 명 (특정 경우에만 데이터 출력) */
        private String mrktWarnClsName;

        /** 주식 기준가 */
        private String stckSdpr;

        /** 업종 구분 코드 */
        private String bstpClsCode;

        /** 주식 전일 종가 */
        private String stckPrdyClpr;

        /** 불성실 공시 여부 */
        private String insnPbntYn;

        /** 액면가 변경 구분 명 (특정 경우에만 데이터 출력) */
        private String fcamModClsName;

        /** 주식 현재가 */
        private String stckPrpr;

        /** 전일 대비 */
        private String prdyVrss;

        /** 전일 대비 부호 */
        private String prdyVrssSign;

        /** 전일 대비율 */
        private String prdyCtrt;

        /** 누적 거래 대금 */
        private String acmlTrPbmn;

        /** 누적 거래량 */
        private String acmlVol;

        /** 전일 대비 거래량 비율 */
        private String prdyVrssVolRate;

        /** 업종 한글 종목명 (※ 거래소 정보로 특정 종목은 업종구분이 없어 데이터 미회신) */
        private String bstpKorIsnm;

        /** 정리매매 여부 */
        private String sltrYn;

        /** 거래정지 여부 */
        private String trhtYn;

        /** 시가 범위 연장 여부 */
        private String oprcRangContYn;

        /** 임의 종료 구분 코드 */
        private String vlntFinClsCode;

        /** 주식 시가2 */
        private String stckOprc;

        /** 전일 거래량 */
        private String prdyVol;
    }

}
