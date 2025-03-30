package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InquirePriceResult extends CommonRestResult {

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

        /** 종목 상태 구분 코드 */
        private String iscdStatClsCode;

        /** 증거금 비율 */
        private String margRate;

        /** 대표 시장 한글 명 */
        private String rprsMrktKorName;

        /** 신 고가 저가 구분 코드 */
        private String newHgprLwprClsCode;

        /** 업종 한글 종목명 */
        private String bstpKorIsnm;

        /** 임시 정지 여부 */
        private String tempStopYn;

        /** 시가 범위 연장 여부 */
        private String oprcRangContYn;

        /** 종가 범위 연장 여부 */
        private String clprRangContYn;

        /** 신용 가능 여부 */
        private String crdtAbleYn;

        /** 보증금 비율 구분 코드 */
        private String grmnRateClsCode;

        /** ELW 발행 여부 */
        private String elwPblcYn;

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

        /** 주식 시가2 */
        private String stckOprc;

        /** 주식 최고가 */
        private String stckHgpr;

        /** 주식 최저가 */
        private String stckLwpr;

        /** 주식 상한가 */
        private String stckMxpr;

        /** 주식 하한가 */
        private String stckLlam;

        /** 주식 기준가 */
        private String stckSdpr;

        /** 가중 평균 주식 가격 */
        private String wghnAvrgStckPrc;

        /** HTS 외국인 소진율 */
        private String htsFrgnEhrt;

        /** 외국인 순매수 수량 */
        private String frgnNtbyQty;

        /** 프로그램매매 순매수 수량 */
        private String pgtrNtbyQty;

        /** 피벗 2차 디저항 가격 */
        private String pvtScndDmrsPrc;

        /** 피벗 1차 디저항 가격 */
        private String pvtFrstDmrsPrc;

        /** 피벗 포인트 값 */
        private String pvtPontVal;

        /** 피벗 1차 디지지 가격 */
        private String pvtFrstDmspPrc;

        /** 피벗 2차 디지지 가격 */
        private String pvtScndDmspPrc;

        /** 디저항 값 */
        private String dmrsVal;

        /** 디지지 값 */
        private String dmspVal;

        /** 자본금 */
        private String cpfn;

        /** 제한 폭 가격 */
        private String rstcWdthPrc;

        /** 주식 액면가 */
        private String stckFcam;

        /** 주식 대용가 */
        private String stckSspr;

        /** 호가단위 */
        private String asprUnit;

        /** HTS 매매 수량 단위 값 */
        private String htsDealQtyUnitVal;

        /** 상장 주수 */
        private String lstnStcn;

        /** HTS 시가총액 */
        private String htsAvls;

        /** PER */
        private String per;

        /** PBR */
        private String pbr;

        /** 결산 월 */
        private String stacMonth;

        /** 거래량 회전율 */
        private String volTnrt;

        /** EPS */
        private String eps;

        /** BPS */
        private String bps;

        /** 250일 최고가 */
        private String d250Hgpr;

        /** 250일 최고가 일자 */
        private String d250HgprDate;

        /** 250일 최고가 대비 현재가 비율 */
        private String d250HgprVrssPrprRate;

        /** 250일 최저가 */
        private String d250Lwpr;

        /** 250일 최저가 일자 */
        private String d250LwprDate;

        /** 250일 최저가 대비 현재가 비율 */
        private String d250LwprVrssPrprRate;

        /** 주식 연중 최고가 */
        private String stckDryyHgpr;

        /** 연중 최고가 대비 현재가 비율 */
        private String dryyHgprVrssPrprRate;

        /** 연중 최고가 일자 */
        private String dryyHgprDate;

        /** 주식 연중 최저가 */
        private String stckDryyLwpr;

        /** 연중 최저가 대비 현재가 비율 */
        private String dryyLwprVrssPrprRate;

        /** 연중 최저가 일자 */
        private String dryyLwprDate;

        /** 52주일 최고가 */
        private String w52Hgpr;

        /** 52주일 최고가 대비 현재가 대비 */
        private String w52HgprVrssPrprCtrt;

        /** 52주일 최고가 일자 */
        private String w52HgprDate;

        /** 52주일 최저가 */
        private String w52Lwpr;

        /** 52주일 최저가 대비 현재가 대비 */
        private String w52LwprVrssPrprCtrt;

        /** 52주일 최저가 일자 */
        private String w52LwprDate;

        /** 전체 융자 잔고 비율 */
        private String wholLoanRmndRate;

        /** 공매도가능여부 */
        private String sstsYn;

        /** 주식 단축 종목코드 */
        private String stckShrnIscd;

        /** 액면가 통화명 */
        private String fcamCnnm;

        /** 자본금 통화명 */
        private String cpfnCnnm;

        /** 접근도 */
        private String apprchRate;

        /** 외국인 보유 수량 */
        private String frgnHldnQty;

        /** VI적용구분코드 */
        private String viClsCode;

        /** 시간외단일가VI적용구분코드 */
        private String ovtmViClsCode;

        /** 최종 공매도 체결 수량 */
        private String lastSstsCntgQty;

        /** 투자유의여부 */
        private String invtCafulYn;

        /** 시장경고코드 */
        private String mrktWarnClsCode;

        /** 단기과열여부 */
        private String shortOverYn;

        /** 정리매매여부 */
        private String sltrYn;

        /** 관리종목여부 */
        private String mangIssuClsCode;
    }

}
