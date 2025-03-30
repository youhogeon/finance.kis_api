package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestResult;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class EtfetnInquirePriceResult extends CommonRestResult {

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

        /** 주식 현재가 */
        private String stckPrpr;

        /** 전일 대비 부호 */
        private String prdyVrssSign;

        /** 전일 대비 */
        private String prdyVrss;

        /** 전일 대비율 */
        private String prdyCtrt;

        /** 누적 거래량 */
        private String acmlVol;

        /** 전일 거래량 */
        private String prdyVol;

        /** 주식 상한가 */
        private String stckMxpr;

        /** 주식 하한가 */
        private String stckLlam;

        /** 주식 전일 종가 */
        private String stckPrdyClpr;

        /** 주식 시가2 */
        private String stckOprc;

        /** 전일 종가 대비 시가2 비율 */
        private String prdyClprVrssOprcRate;

        /** 주식 최고가 */
        private String stckHgpr;

        /** 전일 종가 대비 최고가 비율 */
        private String prdyClprVrssHgprRate;

        /** 주식 최저가 */
        private String stckLwpr;

        /** 전일 종가 대비 최저가 비율 */
        private String prdyClprVrssLwprRate;

        /** 전일 최종 NAV */
        private String prdyLastNav;

        /** NAV */
        private String nav;

        /** NAV 전일 대비 */
        private String navPrdyVrss;

        /** NAV 전일 대비 부호 */
        private String navPrdyVrssSign;

        /** NAV 전일 대비율 */
        private String navPrdyCtrt;

        /** 추적 오차율 */
        private String trcErrt;

        /** 주식 기준가 */
        private String stckSdpr;

        /** 주식 대용가 */
        private String stckSspr;

        /** 지수 대비율 */
        private String nmixCtrt;

        /** ETF 유통 주수 */
        private String etfCrclStcn;

        /** ETF 순자산 총액 */
        private String etfNtasTtam;

        /** ETF 외화 순자산 총액 */
        private String etfFrcrNtasTtam;

        /** 외국인 한도 비율 */
        private String frgnLimtRate;

        /** 외국인 주문 가능 수량 */
        private String frgnOderAbleQty;

        /** ETF CU 단위 증권 수 */
        private String etfCuUnitScrtCnt;

        /** ETF 구성 종목 수 */
        private String etfCnfgIssuCnt;

        /** ETF 배당 주기 */
        private String etfDvdnCycl;

        /** 통화 코드 */
        private String crcd;

        /** ETF 유통 순자산 총액 */
        private String etfCrclNtasTtam;

        /** ETF 외화 유통 순자산 총액 */
        private String etfFrcrCrclNtasTtam;

        /** ETF 외화 최종 순자산 가치 값 */
        private String etfFrcrLastNtasWrthVal;

        /** LP 주문 가능 구분 코드 */
        private String lpOderAbleClsCode;

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

        /** 업종 한글 종목명 (※ 거래소 정보로 특정 종목은 업종구분이 없어 데이터 미회신) */
        private String bstpKorIsnm;

        /** VI적용구분코드 */
        private String viClsCode;

        /** 상장 주수 */
        private String lstnStcn;

        /** 외국인 보유 수량 */
        private String frgnHldnQty;

        /** 외국인 보유 수량 비율 */
        private String frgnHldnQtyRate;

        /** ETF 추적 수익률 배수 */
        private String etfTrcErtMltp;

        /** 괴리율 */
        private String dprt;

        /** 회원사 명 */
        private String mbcrName;

        /** 주식 상장 일자 */
        private String stckLstnDate;

        /** 만기 일자 */
        private String mtrtDate;

        /** 분배금형태코드 */
        private String shrgTypeCode;

        /** LP 보유 비율 */
        private String lpHldnRate;

        /** ETF대상지수업종코드 */
        private String etfTrgtNmixBstpCode;

        /** ETF 분류 명 */
        private String etfDivName;

        /** ETF 대표 업종 한글 종목명 */
        private String etfRprsBstpKorIsnm;

        /** ETN LP 보유량 */
        private String lpHldnVol;
    }

}
