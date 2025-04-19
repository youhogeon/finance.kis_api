package com.youhogeon.finance.kis_api.api.special;

import com.youhogeon.finance.kis_api.api.ApiResult;

import lombok.Data;

@Data
public class RateLimitInfoResult implements ApiResult {

    int remainingQuota;

}
