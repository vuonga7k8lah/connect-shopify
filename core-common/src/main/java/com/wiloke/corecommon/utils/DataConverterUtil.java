package com.wiloke.corecommon.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;

import java.util.List;

public class DataConverterUtil<T> {
    private Class<T> type;

    public DataConverterUtil(Class<T> type) {
        this.type = type;
    }

    public Class<T> getMyType() {
        return this.type;
    }

    public static String toString(Object object) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(object);
    }

    public static String toJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public T toObject(String string) throws JsonProcessingException {
        return (new ObjectMapper().readValue(string, this.getMyType()));
    }

    public static String toBase64(String string) {
        return Base64Util.encode(string);
    }

    public static String decodeBase64(String base64) {
        return Base64Util.decode(base64);
    }

    public static List<String> convertListObjectToListString(List<?> objectList) {
        if (objectList == null) {
            return null;
        }

        Gson gson = new Gson();
        return objectList.stream()
                .map(gson::toJson).toList();
    }
}
