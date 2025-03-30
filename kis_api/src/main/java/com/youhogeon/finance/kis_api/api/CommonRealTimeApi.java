package com.youhogeon.finance.kis_api.api;

import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.auth.ApprovalKeyRequired;
import com.youhogeon.finance.kis_api.api.realtime.TransactionType;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@ApprovalKeyRequired(location = ApprovalKeyRequired.Location.HEADER)
public abstract class CommonRealTimeApi<T extends ApiResult> implements Api<T> {

    public CommonRealTimeApi(String trId, String trKey) {
        this.trId = trId;
        this.trKey = trKey;
    }

    @Header
    private String custtype = "P";

    @Header
    private TransactionType trType = TransactionType.SUBSCRIBE;

    @Header("content-type")
    private String contentType = "utf-8";

    @NonNull
    @Body
    private String trId;

    @NonNull
    @Body
    private String trKey;

}
