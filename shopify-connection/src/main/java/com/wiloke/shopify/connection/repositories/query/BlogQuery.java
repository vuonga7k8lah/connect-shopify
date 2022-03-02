package com.wiloke.shopify.connection.repositories.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiloke.shopify.connection.dto.shopify.CollectionDTO;
import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
import com.wiloke.shopify.connection.utils.AccessToken;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;

@Repository(value = "BlogQuery")
@Data
public class BlogQuery implements ShopifyQueryable {
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
        HttpClient httpClient = HttpClient.newHttpClient();
        var endpoint= this.endpoint.replace("graphql.json","blogs.json");
        this.httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .headers("Content-Type", "application/json")
                .headers("X-Shopify-Access-Token",  AccessToken.token)
                .GET()
                .build();
        return httpClient;
    }

    @Override
    public HttpResponse<String> query(Collections params) throws Exception {
        return this.query();
    }

    @Override
    public HttpResponse<String> query() throws Exception {
        return this.buildHttpClient().send(this.httpRequest, HttpResponse.BodyHandlers.ofString());

    }
}
