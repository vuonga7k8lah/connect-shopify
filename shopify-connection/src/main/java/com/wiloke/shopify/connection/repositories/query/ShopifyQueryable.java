package com.wiloke.shopify.connection.repositories.query;

import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Collections;

public interface ShopifyQueryable {
    HttpClient buildHttpClient();

    HttpResponse<String> query(Collections params) throws Exception;

    HttpResponse<String> query() throws Exception;

    ShopifyQueryable setEndpoint(String endpoint);

    ShopifyQueryable setId(String id);

    ShopifyQueryable setGraphQLQuery(String query);

    ShopifyQueryable setOfflineToken(String offlineToken);

    QueryCostDTO extensions = null;
}
