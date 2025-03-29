package com.youhogeon.finance.kis_api.api.rest;

import java.util.function.Supplier;

import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.api.annotation.Header;

import lombok.Getter;
import lombok.Setter;

/**
 * 다중 페이지(연속조회)가 필요한 API의 경우
 * PageableResult를 상속받는 ApiResult class를 만듦으로써
 * next() 메서드를 사용할 수 있음.
 */
@Setter
@Getter
public abstract class PageableApiResult<T extends ApiResult> implements ApiResult {

    @Header("tr_cont")
    private String trCont;

    private String ctxAreaFk;
    private String ctxAreaNk;

    private String ctxAreaFk100;
    private String ctxAreaNk100;

    private String ctxAreaFk200;
    private String ctxAreaNk200;

    private final Supplier<T> nextFunction = null;

    public final T next() {
        if (
            nextFunction == null
            || (
                !trCont.equals("F")
                && !trCont.equals("M")
            )
        ) {
            return null;
        }

        return nextFunction.get();
    }

}
