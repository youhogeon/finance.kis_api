package com.youhogeon.finance.kis_api.util;

import java.util.Map;

public class CredentialsUtil {

    public static MaskingHashMap<String, Object> maskMap(Map<String, Object> data, String[] keys) {
        MaskingHashMap<String, Object> maskedData = MaskingHashMap.from(data);
        maskedData.setMaskString("<hidden>");

        for (String key : keys) {
            if (!data.containsKey(key)) {
                continue;
            }

            maskedData.mask(key);
        }

        return maskedData;
    }

    public static String maskAccessToken(String data) {
        String maskedData = data.replaceAll("\"access_token\":\"[^\"]*\"", "\"access_token\":\"***\"");

        return maskedData;
    }

}
