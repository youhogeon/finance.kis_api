package com.youhogeon.finance.kis_api.api;

import lombok.Getter;

@Getter
public class H0STCNT0Response implements ApiResult {

    private String mkscShrnIscd;          // 유가증권 단축 종목코드
    private String stckCntgHour;          // 주식 체결 시간
    private int stckPrpr;                 // 주식 현재가
    private String prdyVrssSign;          // 전일 대비 부호
    private int prdyVrss;                 // 전일 대비
    private double prdyCtrt;              // 전일 대비율
    private double wghnAvrgStckPrc;       // 가중 평균 주식 가격
    private int stckOprc;                 // 주식 시가
    private int stckHgpr;                 // 주식 최고가
    private int stckLwpr;                 // 주식 최저가
    private int askp1;                    // 매도호가1
    private int bidp1;                    // 매수호가1
    private long cntgVol;                 // 체결 거래량
    private long acmlVol;                 // 누적 거래량
    private long acmlTrPbmn;              // 누적 거래 대금
    private int selnCntgCsnu;             // 매도 체결 건수
    private int shnuCntgCsnu;             // 매수 체결 건수
    private int ntbyCntgCsnu;             // 순매수 체결 건수
    private double cttr;                  // 체결강도
    private long selnCntgSmtn;            // 총 매도 수량
    private long shnuCntgSmtn;            // 총 매수 수량
    private String ccldDvsn;              // 체결구분
    private double shnuRate;              // 매수비율
    private double prdyVolVrssAcmlVolRate;// 전일 거래량 대비 등락율
    private String oprcHour;              // 시가 시간
    private String oprcVrssPrprSign;      // 시가대비구분
    private int oprcVrssPrpr;             // 시가대비
    private String hgprHour;              // 최고가 시간
    private String hgprVrssPrprSign;      // 고가대비구분
    private int hgprVrssPrpr;             // 고가대비
    private String lwprHour;              // 최저가 시간
    private String lwprVrssPrprSign;      // 저가대비구분
    private int lwprVrssPrpr;             // 저가대비
    private String bsopDate;              // 영업 일자
    private String newMkopClsCode;        // 신 장운영 구분 코드
    private String trhtYn;                // 거래정지 여부
    private long askpRsqn1;               // 매도호가 잔량1
    private long bidpRsqn1;               // 매수호가 잔량1
    private long totalAskpRsqn;           // 총 매도호가 잔량
    private long totalBidpRsqn;           // 총 매수호가 잔량
    private double volTnrt;               // 거래량 회전율
    private long prdySmnsHourAcmlVol;     // 전일 동시간 누적 거래량
    private double prdySmnsHourAcmlVolRate;// 전일 동시간 누적 거래량 비율
    private String hourClsCode;           // 시간 구분 코드
    private String mrktTrtmClsCode;       // 임의종료구분코드
    private int viStndPrc;                // 정적VI발동기준가

}
