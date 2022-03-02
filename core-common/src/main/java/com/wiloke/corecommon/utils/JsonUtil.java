package com.wiloke.corecommon.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public class JsonUtil {
    public static String toString(Object object) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(object);
    }

    public static Object toObject(String string) throws JsonProcessingException {
        return (new ObjectMapper().readValue(string, Object.class));
    }
}
