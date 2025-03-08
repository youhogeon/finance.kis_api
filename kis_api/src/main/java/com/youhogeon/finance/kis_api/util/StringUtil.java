package com.youhogeon.finance.kis_api.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

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

    public static String decryptAes256(String data, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            byte[] decodedData = Base64.getDecoder().decode(data);
            byte[] decrypted = cipher.doFinal(decodedData);

            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    public static String[] fastSplit(String str, char delimiter) {
        int count = 0;
        int pos = 0;

        while (true) {
            int index = str.indexOf(delimiter, pos);
            if (index == -1) break;

            count++;
            pos = index + 1;
        }

        String[] result = new String[count + 1];
        pos = 0;
        int i = 0;

        while (true) {
            int index = str.indexOf(delimiter, pos);
            if (index == -1) break;

            result[i++] = str.substring(pos, index);
            pos = index + 1;
        }
        result[i] = str.substring(pos);
        return result;
    }

}
