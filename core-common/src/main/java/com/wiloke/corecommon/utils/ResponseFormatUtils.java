package com.wiloke.corecommon.utils;

import java.util.*;

public class ResponseFormatUtils {

    public static Map<String, String> build(String message) {
        Map<String, String> map = new HashMap<>();
        map.put("message", message);

        return map;
    }

    public static <T> Map<String, Object> build(T response, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("info", response);

        return map;
    }

    public static Map<String, Object> build(Long id, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("message", message);

        return map;
    }

    public static <T> Map<String, Object> build(List<T> lists, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("info", lists);
        map.put("message", message);

        return map;
    }

}
