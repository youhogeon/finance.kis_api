package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 국내주식 장마감 예상체결가[국내주식-120]
 */
@NoArgsConstructor
@Setter
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/exp-closing-price")
public class ExpClosingPriceApi extends CommonRestApi<ExpClosingPriceResult> {

    @Header
    private String trId = "FHKST117300C0";

    /**
     * 순위 정렬 구분 코드
     *
     * 0:전체, 1:상한가마감예상, 2:하한가마감예상, 3:직전대비상승률상위 ,4:직전대비하락률상위
     */
    @Parameter
    private String fidRankSortClsCode = "0";

    /**
     * 조건 시장 분류 코드
     *
     * 시장구분코드 (주식 J)
     */
    @Parameter
    private String fidCondMrktDivCode = "J";

    /**
     * 조건 화면 분류 코드
     *
     * Unique key(11173)
     */
    @Parameter
    private String fidCondScrDivCode = "11173";

    /**
     * 입력 종목코드
     *
     * 0000:전체, 0001:거래소, 1001:코스닥, 2001:코스피200, 4001: KRX100
     */
    @Parameter
    private String fidInputIscd = "0000";

    /**
     * 소속 구분 코드
     *
     * 0:전체, 1:종가범위연장
     */
    @Parameter
    private String fidBlngClsCode = "0";

}
