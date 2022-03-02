package com.wiloke.shopify.connection.repositories;

import com.wiloke.shopify.connection.repositories.query.ShopifyQueryable;

public interface ShopifyAble {

    ShopifyAble withShopName(String shopName);

    ShopifyAble withPluckResponse(String query);

    ShopifyAble withOfflineToken(String offlineToken);

    ShopifyAble withVersion(String version);

    <T extends ShopifyQueryable, R> R query(T shopifyQuery, R mappingJsonToObject) throws Exception;

    Integer codeStatus();
}
