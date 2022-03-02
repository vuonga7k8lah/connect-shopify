//package com.wiloke.shopify.connection.repositories.query;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
//import com.wiloke.shopify.connection.dto.shopify.ShopDTO;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.net.URI;
//import java.net.http.HttpClient;
////import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.Collections;
//@Repository(value = "ShopLocalesQuery")
//@Data
//public class ShopLocalesQuery implements ShopifyQueryAble{
//
////    private String endpoint;
//    private String offlineToken;
//    private HttpRequest httpRequest;
//    private QueryCostDTO extensions;
//    private ShopDTO data;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Override
//    public HttpClient buildHttpClient() {
//        var bodyPublisher = HttpRequest.BodyPublishers.ofString("query {\n" +
//                "    shopLocales {\n" +
//                "      locale\n" +
//                "      name\n" +
//                "      primary\n" +
//                "      published\n" +
//                "    }\n" +
//                "  }\n");
//        HttpClient httpClient = HttpClient.newHttpClient();
//        this.httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create(this.endpoint))
//                .headers("Content-Type", "application/graphql")
//                .headers("X-Shopify-Access-Token", this.offlineToken)
//                .POST(bodyPublisher)
//                .build();
//
//        return httpClient;
//    }
//
//    @Override
//    public HttpResponse<String> query(Collections params) throws Exception {
//        return this.query();
//    }
//
//    @Override
//    public HttpResponse<String> query() throws Exception {
//        return this.buildHttpClient().send(this.httpRequest, HttpResponse.BodyHandlers.ofString());
//    }
//
//    @Override
//    public ShopifyQueryAble setEndpoint(String endpoint) {
//        this.endpoint = endpoint;
//        return this;
//    }
//
//    @Override
//    public ShopifyQueryAble setOfflineToken(String offlineToken) {
//        this.offlineToken = offlineToken;
//        return this;
//    }
//}
