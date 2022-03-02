package com.wiloke.corecommon.utils;

public class Base64Util {
    public static String encode(String item) {
        if (item == null) {
            return null;
        }

        return java.util.Base64.getEncoder().encodeToString(item.getBytes());
    }

    public static String decode(String base64) {
        if (base64 == null) {
            return null;
        }

        byte[] decodedBytes = java.util.Base64.getDecoder().decode(base64);
        return new String(decodedBytes);
    }
}
