package com.wiloke.corecommon.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class ArrayUtil {
    private final static String separator = "--item--";

    public static <K, V> TreeMap<K, V> kSort(Map<K, V> map) {
        return new TreeMap<>(map);
    }

    public static String toString(List<String> list) {
        return String.join(separator, list);
    }

    public static List<String> toArray(String string) {
        var items = new ArrayList<>(Arrays.asList(string.split(separator)));
        return items.stream().map(item -> {
            try {
                return (new ObjectMapper().readValue(item, String.class));
            } catch (JsonProcessingException e) {
                return null;
            }
        }).toList();
    }
}
