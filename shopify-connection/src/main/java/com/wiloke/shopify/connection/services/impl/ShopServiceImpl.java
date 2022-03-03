package com.wiloke.shopify.connection.services.impl;

import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
import com.wiloke.shopify.connection.dto.shopify.request.ShopRequestDTO;
import com.wiloke.shopify.connection.graphqlbuilder.ShopQueryBuilder;
import com.wiloke.shopify.connection.repositories.Shopify;
import com.wiloke.shopify.connection.repositories.query.ShopifyQueryable;
import com.wiloke.shopify.connection.repositories.skeleton.ShopSkeleton;
import com.wiloke.shopify.connection.services.ShopifyServiceAble;
import com.wiloke.shopify.connection.utils.APIUtil;
import com.wiloke.shopify.connection.utils.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service(value = "ShopServiceImpl")
public class ShopServiceImpl implements ShopifyServiceAble<ShopRequestDTO> {

    @Autowired
    private ShopQueryBuilder shopQueryBuilder;

    @Autowired
    private Shopify shopify;

    @Autowired
    @Qualifier(value = "ShopQuery")
    private ShopifyQueryable shopQuery;

    private ShopSkeleton skeleton;

    private final String offlineToken = "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";

    @Override
    public Object getData(ShopRequestDTO dtoRequestable) throws Exception {
        var shopSkeleton = new ShopSkeleton();
        this.skeleton = this.shopify
                .withOfflineToken(AccessToken.token)
                .withShopName(dtoRequestable.getShopName())
                .withPluckResponse(this.shopQueryBuilder.setRequest(dtoRequestable).build())
                .query(shopQuery, shopSkeleton);

        var data = skeleton.getData();
        if (dtoRequestable.getWithQueryCost()) {
            var queryCost = this.getQueryCost();
            return APIUtil.buildFullResponse(data, queryCost);
        }
        var formatData = new HashMap<String, Object>();
        formatData.put("shop", data.getShop());
        return formatData;
    }

    @Override
    public QueryCostDTO getQueryCost() {
        return null;
    }
}
