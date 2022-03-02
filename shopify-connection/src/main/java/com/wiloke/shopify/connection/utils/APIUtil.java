package com.wiloke.shopify.connection.utils;

import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIUtil {
    public final static String API_VERSION = "v1";
    public final static String DS = "/";
    public final static String ROOT_NAMESPACE = "vge";

    public final static String COLLECTION_NAMESPACE = "collections";
    public final static String COLLECTION_ENDPOINT = ROOT_NAMESPACE + DS + API_VERSION + DS + COLLECTION_NAMESPACE;

    public final static String SHOP_INFO_NAMESPACE = "shops";
    public final static String SHOP_INFO_ENDPOINT = ROOT_NAMESPACE + DS + API_VERSION + DS + SHOP_INFO_NAMESPACE;

    public final static String PRODUCT_NAMESPACE = "products";
    public final static String PRODUCT_ENDPOINT = ROOT_NAMESPACE + DS + API_VERSION + DS + PRODUCT_NAMESPACE;

    public final static String ORDER_NAMESPACE = "orders";
    public final static String ORDER_ENDPOINT = ROOT_NAMESPACE + DS + API_VERSION + DS + ORDER_NAMESPACE;

    public final static String CUSTOMER_NAMESPACE = "customers";
    public final static String CUSTOMER_ENDPOINT = ROOT_NAMESPACE + DS + API_VERSION + DS + CUSTOMER_NAMESPACE;

    public final static String BLOG_NAMESPACE = "blogs";
    public final static String BLOG_ENDPOINT = ROOT_NAMESPACE + DS + API_VERSION + DS + BLOG_NAMESPACE;

    public final static String ARTICLE_NAMESPACE = "articles";
    public final static String ARTICLE_ENDPOINT = ROOT_NAMESPACE + DS + API_VERSION + DS + ARTICLE_NAMESPACE;

    public final static String PAGE_NAMESPACE = "pages";
    public final static String PAGE_ENDPOINT = ROOT_NAMESPACE + DS + API_VERSION + DS + PAGE_NAMESPACE;

    public final static String CHECKOUT_NAMESPACE = "checkouts";
    public final static String CHECKOUT_ENDPOINT = ROOT_NAMESPACE + DS + API_VERSION + DS + CHECKOUT_NAMESPACE;

    public final static String CART_NAMESPACE = "carts";
    public final static String CART_ENDPOINT = ROOT_NAMESPACE + DS + API_VERSION + DS + CART_NAMESPACE;

    public final static String COMMENT_NAMESPACE = "comments";
    public final static String COMMENT_ENDPOINT = ROOT_NAMESPACE + DS + API_VERSION + DS + COMMENT_NAMESPACE;

    public final static String SHOP_GRAPHQL_INFO_NAMESPACE = "shopgraphql";
    public final static String SHOP_GRAPHQL_INFO_ENDPOINT = ROOT_NAMESPACE + DS + API_VERSION + DS + SHOP_GRAPHQL_INFO_NAMESPACE;



    public static Map<String, Object> buildFullResponse(Object data, QueryCostDTO queryCostDTO) {
        var response = new HashMap<String, Object>();
        response.put("queryCost", queryCostDTO);
        response.put("data", data);

        return response;
    }
}
