package com.wiloke.shopify.connection.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiloke.shopify.connection.dto.shopify.request.DTORequestable;
import com.wiloke.shopify.connection.graphqlbuilder.ShopQueryBuilder;
import com.wiloke.shopify.connection.repositories.query.ShopifyQueryable;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Repository;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Repository
@Data
@ConfigurationPropertiesScan(basePackages = "com.wiloke.shopify.connection")
public class Shopify implements ShopifyAble {
    private ShopifyAble shopifySDK;
    private String shopName;
    private String id;
    private String handles;
    private String offlineToken;
    private DTORequestable dtoRequestable;

    @Value("${shopify.version}")
    private String version;
    @Value("${shopify.rootEndpoint}")
    private String rootEndpoint;
    @Value("${shopify.shopifyDomain}")
    private String shopifyDomain;

    private HttpClient httpClient;
    private HttpRequest httpRequest;
    private HttpRequest.BodyPublisher bodyPublisher;
    private HttpResponse<String> response;

    @Autowired
    private ShopQueryBuilder shopQueryBuilder;

    @Autowired
    private ObjectMapper objectMapper;
    private String graphQLQuery;
    private String target;

    @Override
    public ShopifyAble withShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    @Override
    public ShopifyAble withPluckResponse(String query) {
        this.graphQLQuery = query;
        return this;
    }

    @Override
    public ShopifyAble withOfflineToken(String offlineToken) {
        this.offlineToken = offlineToken;
        return this;
    }

    @Override
    public ShopifyAble withVersion(String version) {
        this.version = version;
        return this;
    }

    public ShopifyAble withId(String id) {
        this.id = id;
        return this;
    }

    public ShopifyAble withHandles(String handles){
        this.handles= handles;
        return this;
    }

    @Override
    public <T extends ShopifyQueryable, R> R query(T shopifyQuery, R mappingJsonToObject) throws Exception {
        this.response = shopifyQuery
                .setId(id)
                .setHandles(this.handles)
                .setEndpoint(this.buildRootEndpoint())
                .setOfflineToken(this.offlineToken)
                .setGraphQLQuery(this.graphQLQuery)
                .query();
        //System.out.println(this.graphQLQuery);
        //System.out.println(this.response.body());
        return this.parseBody(mappingJsonToObject);
    }

    private <R> R parseBody(R mappingJsonToObject) throws JsonProcessingException {
        var objectMapper = new ObjectMapper();
        return objectMapper.reader().forType(mappingJsonToObject.getClass()).readValue(response.body());
    }

    @Override
    public Integer codeStatus() {
        return response.statusCode();
    }

    private String buildRootEndpoint() {
        if (!this.shopName.contains(this.shopifyDomain)) {
            this.shopName = this.shopName.trim() + "." + this.shopifyDomain;
        }
        this.rootEndpoint = this.rootEndpoint.replace("{shopName}", this.shopName).replace("{version}", this.version);
        return this.rootEndpoint;
    }
}
