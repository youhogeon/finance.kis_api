package com.youhogeon.finance.kis_api.util;

public class StringUtil {

    public static String concatUrl(String url, String path) {
        if (url.endsWith("/") && path.startsWith("/")) {
            return url + path.substring(1);
        } else if (!url.endsWith("/") && !path.startsWith("/")) {
            return url + "/" + path;
        } else {
            return url + path;
        }
    }

}
