package com.wiloke.shopify.connection.services.impl;

import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
import com.wiloke.shopify.connection.dto.shopify.request.CollectionRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.request.OrderRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.skeleton.CollectionSkeleton;
import com.wiloke.shopify.connection.graphqlbuilder.CollectionQueryBuilder;
import com.wiloke.shopify.connection.graphqlbuilder.OrderQueryBuilder;
import com.wiloke.shopify.connection.repositories.Shopify;
import com.wiloke.shopify.connection.repositories.query.ShopifyQueryable;
import com.wiloke.shopify.connection.repositories.skeleton.OrderSkeleton;
import com.wiloke.shopify.connection.services.ShopifyServiceAble;
import com.wiloke.shopify.connection.utils.APIUtil;
import com.wiloke.shopify.connection.utils.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "OrderServiceImpl")
public class OrderServiceImpl implements ShopifyServiceAble<OrderRequestDTO> {
    @Autowired
    private Shopify shopify;

    @Autowired
    @Qualifier(value = "OrderQuery")
    private ShopifyQueryable shopQuery;

    private OrderSkeleton skeleton;

    private final String offlineToken = "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";

    @Override
    public QueryCostDTO getQueryCost() {
        return this.skeleton.getExtensions();
    }

    @Autowired
    private OrderQueryBuilder orderQueryBuilder;

    @Override
    public Object getData(OrderRequestDTO orderRequestDTO) throws Exception {
        var orderSkeleton = new OrderSkeleton();
        this.skeleton = this.shopify
                .withOfflineToken(AccessToken.token)
                .withShopName(orderRequestDTO.getShopName())
                .withPluckResponse(this.orderQueryBuilder.setRequest(orderRequestDTO).build())
                .query(shopQuery, orderSkeleton);

        var data = skeleton.getData();
        if (orderRequestDTO.getWithQueryCost()) {
            var queryCost = this.getQueryCost();
            return APIUtil.buildFullResponse(data, queryCost);
        }

        return data;
    }
}
