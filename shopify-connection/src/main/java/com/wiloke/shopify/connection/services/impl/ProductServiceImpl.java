package com.wiloke.shopify.connection.services.impl;

import com.wiloke.shopify.connection.dto.shopify.ProductEdgesDTO;
import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
import com.wiloke.shopify.connection.dto.shopify.request.ProductRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.request.ShopRequestDTO;
import com.wiloke.shopify.connection.graphqlbuilder.ProductQueryBuilder;
import com.wiloke.shopify.connection.graphqlbuilder.ShopQueryBuilder;
import com.wiloke.shopify.connection.repositories.Shopify;
import com.wiloke.shopify.connection.repositories.query.ShopifyQueryable;
import com.wiloke.shopify.connection.repositories.skeleton.ProductSkeleton;
import com.wiloke.shopify.connection.repositories.skeleton.ShopSkeleton;
import com.wiloke.shopify.connection.services.ShopifyServiceAble;
import com.wiloke.shopify.connection.utils.APIUtil;
import com.wiloke.shopify.connection.utils.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service(value = "ProductServiceImpl")
public class ProductServiceImpl implements ShopifyServiceAble<ProductRequestDTO> {
    @Autowired
    private ProductQueryBuilder productQueryBuilder;

    @Autowired
    private Shopify shopify;

    @Autowired
    @Qualifier(value = "ProductQuery")
    private ShopifyQueryable productQuery;

    private ProductSkeleton skeleton;

    private final String offlineToken = "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";

    @Override
    public Object getData(ProductRequestDTO productRequestDTO) throws Exception {
        var productSkeleton= new ProductSkeleton();
        this.skeleton = this.shopify
                .withOfflineToken(AccessToken.token)
                .withShopName(productRequestDTO.getShopName())
                .withPluckResponse(this.productQueryBuilder.setRequest(productRequestDTO).build())
                .query(productQuery, productSkeleton);

        var data = skeleton.getData();
        if (productRequestDTO.getWithQueryCost()) {
            var queryCost = this.getQueryCost();
            return APIUtil.buildFullResponse(data, queryCost);
        }
        return data.getProducts().getEdges().stream().map(ProductEdgesDTO::getNode).collect(Collectors.toList());
    }

    @Override
    public QueryCostDTO getQueryCost() {
        return this.skeleton.getExtensions();
    }
}
