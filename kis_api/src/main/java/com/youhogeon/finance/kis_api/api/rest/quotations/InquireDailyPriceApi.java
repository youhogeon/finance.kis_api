package com.youhogeon.finance.kis_api.api.rest.quotations;

import com.youhogeon.finance.kis_api.api.CommonRestApi;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 주식현재가 일자별[v1_국내주식-010]
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@RestApi(method = RestApi.Method.GET, path = "/uapi/domestic-stock/v1/quotations/inquire-daily-price")
public class InquireDailyPriceApi extends CommonRestApi<InquireDailyPriceResult> {

    @Header
    private String trId = "FHKST01010400";

    /**
     * 조건 시장 분류 코드
     *
     * J:KRX, NX:NXT, UN:통합
     */
    @Parameter
    private String fidCondMrktDivCode = "UN";

    /**
     * 입력 종목코드
     *
     * 종목코드 (ex 005930 삼성전자)
     */
    @Parameter
    @NonNull
    private String fidInputIscd;

    /**
     * 기간 분류 코드
     *
     * 'D : (일)최근 30거래일 W : (주)최근 30주 M : (월)최근 30개월'
     */
    @Parameter
    private String fidPeriodDivCode = "D";

    /**
     * 수정주가 원주가 가격
     *
     * '0 : 수정주가미반영1 : 수정주가반영* 수정주가는 액면분할/액면병합 등 권리 발생 시 과거 시세를 현재 주가에 맞게 보정한 가격'
     */
    @Parameter
    private String fidOrgAdjPrc = "1";

}
