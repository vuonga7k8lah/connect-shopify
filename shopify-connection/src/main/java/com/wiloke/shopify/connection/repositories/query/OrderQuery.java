package com.wiloke.shopify.connection.repositories.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiloke.shopify.connection.dto.shopify.CollectionDTO;
import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;

@Data
@Repository(value = "OrderQuery")
public class OrderQuery implements ShopifyQueryable{
    private String endpoint;
    private String id;
    private String offlineToken;
    private HttpRequest httpRequest;
    private QueryCostDTO extensions;
    private CollectionDTO collections;
    private String grapQLQuery;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ShopifyQueryable setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    @Override
    public ShopifyQueryable setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public ShopifyQueryable setOfflineToken(String offlineToken) {
        this.offlineToken = offlineToken;
        return this;
    }

    @Override
    public ShopifyQueryable setGraphQLQuery(String query) {
        this.grapQLQuery = query;
        return this;
    }

    @Override
    public HttpClient buildHttpClient() {
        var bodyPublisher = HttpRequest.BodyPublishers.ofString(this.grapQLQuery);
        HttpClient httpClient = HttpClient.newHttpClient();
        this.httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(this.endpoint))
                .headers("Content-Type", "application/graphql")
                .headers("X-Shopify-Access-Token", this.offlineToken)
                .POST(bodyPublisher)
                .build();
//        System.out.println(this.httpRequest);
        return httpClient;
    }

    @Override
    public HttpResponse<String> query(Collections params) throws Exception {
        return this.query();
    }

    @Override
    public HttpResponse<String> query() throws Exception {
        //System.out.println(query.body());
        return this.buildHttpClient().send(this.httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
