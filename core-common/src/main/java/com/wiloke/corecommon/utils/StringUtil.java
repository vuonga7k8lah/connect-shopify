package com.wiloke.corecommon.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.apache.commons.codec.binary.Hex;

public class StringUtil {

    private static final String HMAC_SHA256 = "HmacSHA256";
    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    StringUtil() {
    }

    public static StringUtil getInstance() {
        return new StringUtil();
    }

    public String toSlug(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    public static String randomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }

    public static String uniqueId() {
        return UUID.randomUUID().toString();
    }

    public static String httpQueryBuilder(
            AbstractMap<String, Object> params) throws Exception {

        StringBuilder sb = new StringBuilder();

        for (Entry<String, Object> stringStringEntry : params.entrySet()) {
            if (sb.length() > 0) {
                sb.append('&');
            }//w  w  w. j ava2s .  c o m
            sb.append(((Entry<?, ?>) stringStringEntry).getKey()).append("=").append(((Entry<?, ?>) stringStringEntry).getValue());
        }

        return sb.toString();
    }

    public static HashMap<String, Object> queryStringToHashMac(String queryString) throws Exception {

        HashMap<String, Object> data = new HashMap<>();

        final String[] arrParameters = queryString.split("&");
        for (final String tempParameterString : arrParameters) {

            final String[] arrTempParameter = tempParameterString
                    .split("=");

            final String parameterKey = arrTempParameter[0];
            if (arrTempParameter.length >= 2) {
                final String parameterValue = arrTempParameter[1];
                data.put(parameterKey, parameterValue);
            } else {
                data.put(parameterKey, "");
            }
        }

        return data;
    }


    public static String calculateHMAC(String message, String secretKet)
            throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKet.getBytes(), HMAC_SHA256);
        Mac mac = Mac.getInstance(HMAC_SHA256);
        mac.init(secretKeySpec);
        byte[] rawHmac = mac.doFinal(message.getBytes());
        return Hex.encodeHexString(rawHmac);
    }

    public static String base64Encode(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
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
