package com.youhogeon.finance.kis_api.util;

public class CollectionUtil {

    public static String[][] splitArray(String[] arr, int size) {
        int n = arr.length;
        int chunkSize = n / size;
        String[][] result = new String[size][];

        for (int i = 0; i < size; i++) {
            int start = i * chunkSize;
            int end = (i == size - 1) ? n : start + chunkSize;
            result[i] = java.util.Arrays.copyOfRange(arr, start, end);
        }
        return result;
    }

}
