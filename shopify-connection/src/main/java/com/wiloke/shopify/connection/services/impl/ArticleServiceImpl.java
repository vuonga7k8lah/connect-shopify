package com.wiloke.shopify.connection.services.impl;

import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
import com.wiloke.shopify.connection.dto.shopify.request.ArticleRequestDTO;

import com.wiloke.shopify.connection.dto.shopify.request.CollectionRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.skeleton.CollectionSkeleton;
import com.wiloke.shopify.connection.graphqlbuilder.CollectionQueryBuilder;
import com.wiloke.shopify.connection.repositories.Shopify;
import com.wiloke.shopify.connection.repositories.query.ShopifyQueryable;
import com.wiloke.shopify.connection.repositories.skeleton.ArticleSkeleton;
import com.wiloke.shopify.connection.services.ShopifyServiceAble;
import com.wiloke.shopify.connection.utils.APIUtil;
import com.wiloke.shopify.connection.utils.AccessToken;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Data
@Service(value = "ArticleServiceImpl")
public class ArticleServiceImpl implements ShopifyServiceAble<ArticleRequestDTO> {
    @Autowired
    private Shopify shopify;

    @Autowired
    @Qualifier(value = "ArticleQuery")
    private ShopifyQueryable shopQuery;

    private ArticleSkeleton skeleton;

    private final String offlineToken = "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";

    @Override
    public QueryCostDTO getQueryCost() {
        return null;
    }


    @Override
    public Object getData(ArticleRequestDTO dtoRequestable) throws Exception {
        var articleSkeleton = new ArticleSkeleton();
        this.skeleton = this.shopify
                .withId(dtoRequestable.getId())
                .withHandles(dtoRequestable.getHandles())
                .withOfflineToken(AccessToken.token)
                .withShopName(dtoRequestable.getShopName())
                .withPluckResponse("")
                .query(shopQuery, articleSkeleton);

        return skeleton.getArticles();
    }
}
