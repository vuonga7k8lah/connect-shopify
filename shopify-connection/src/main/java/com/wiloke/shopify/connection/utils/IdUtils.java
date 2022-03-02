package com.wiloke.shopify.connection.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdUtils {
    private static final String idPrefix = "gid://shopify/Collection/";

    public static String removeStringFromId(String input) {
        return input.replaceAll("[^\\d]+", "");
    }

    public static String addShopifyIDPrefix(String id) {
        Pattern pattern = Pattern.compile(idPrefix);
        Matcher matcher = pattern.matcher(id);
        boolean matchFound = matcher.find();

        String shopifyId;
        if (!matchFound) {
            String idWithNumberOnly = id.replaceAll("[^\\d]+", "");
            shopifyId = idPrefix + idWithNumberOnly;
        } else {
            shopifyId = id;
        }

        return shopifyId;
    }
}
