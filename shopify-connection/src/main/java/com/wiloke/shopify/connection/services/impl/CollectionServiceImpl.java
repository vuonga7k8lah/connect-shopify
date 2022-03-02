package com.wiloke.shopify.connection.services.impl;

import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
import com.wiloke.shopify.connection.dto.shopify.request.CollectionRequestDTO;
import com.wiloke.shopify.connection.graphqlbuilder.CollectionQueryBuilder;
import com.wiloke.shopify.connection.repositories.Shopify;
import com.wiloke.shopify.connection.repositories.query.ShopifyQueryable;
import com.wiloke.shopify.connection.dto.shopify.skeleton.CollectionSkeleton;
import com.wiloke.shopify.connection.services.ShopifyServiceAble;
import com.wiloke.shopify.connection.utils.APIUtil;
import com.wiloke.shopify.connection.utils.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "CollectionServiceImpl")
public class CollectionServiceImpl implements ShopifyServiceAble<CollectionRequestDTO> {
    @Autowired
    private Shopify shopify;

    @Autowired
    @Qualifier(value = "CollectionsQuery")
    private ShopifyQueryable shopQuery;

    private CollectionSkeleton skeleton;

    private final String offlineToken = "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";

    @Override
    public QueryCostDTO getQueryCost() {
        return this.skeleton.getExtensions();
    }

    @Autowired
    private CollectionQueryBuilder collectionQueryBuilder;

    @Override
    public Object getData(CollectionRequestDTO dtoRequestable) throws Exception {
        var collectionSkeleton = new CollectionSkeleton();
        this.skeleton = this.shopify
                .withOfflineToken(AccessToken.token)
                .withShopName(dtoRequestable.getShopName())
                .withPluckResponse(this.collectionQueryBuilder.setRequest(dtoRequestable).build())
                .query(shopQuery, collectionSkeleton);

        var data = skeleton.getData();
        if (dtoRequestable.getWithQueryCost()) {
            var queryCost = this.getQueryCost();
            return APIUtil.buildFullResponse(data, queryCost);
        }

        return data;
    }
}
