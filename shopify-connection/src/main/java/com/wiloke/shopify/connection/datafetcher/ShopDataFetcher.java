package com.wiloke.shopify.connection.datafetcher;

import com.wiloke.shopify.connection.services.ShopifyServiceAble;
import graphql.servlet.GraphQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import javax.servlet.http.HttpServletRequest;

@Component
public class ShopDataFetcher implements DataFetcher<Object> {
    @Autowired
    @Qualifier(value = "ShopServiceImpl")
    private ShopifyServiceAble shopService;

    @Override
    public Object get(DataFetchingEnvironment env) {
        GraphQLContext context = env.getContext();
        System.out.println(context.getHttpServletRequest());
        HttpServletRequest httpServletRequest = context.getHttpServletRequest().orElseThrow(() -> new IllegalArgumentException("Missing Http Headers"));

        var shopName = httpServletRequest.getHeader("x-shopname");
        if (shopName == null) {
            throw new IllegalArgumentException("The Shop Name is required");
        }

//        try {
//            return this.shopService.getData(shopName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }
}