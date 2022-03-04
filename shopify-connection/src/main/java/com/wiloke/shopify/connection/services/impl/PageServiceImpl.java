package com.wiloke.shopify.connection.services.impl;


import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
import com.wiloke.shopify.connection.dto.shopify.request.PageRequestDTO;
import com.wiloke.shopify.connection.repositories.Shopify;
import com.wiloke.shopify.connection.repositories.query.ShopifyQueryable;
import com.wiloke.shopify.connection.repositories.skeleton.PageSkeleton;
import com.wiloke.shopify.connection.services.ShopifyServiceAble;
import com.wiloke.shopify.connection.utils.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service(value = "PageServiceImpl")
public class PageServiceImpl implements ShopifyServiceAble<PageRequestDTO> {
    @Autowired
    private Shopify shopify;

    @Autowired
    @Qualifier(value = "PageQuery")
    private ShopifyQueryable shopQuery;

    private PageSkeleton skeleton;

    private final String offlineToken = "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";

    @Override
    public QueryCostDTO getQueryCost() {
        return null;
    }


    @Override
    public Object getData(PageRequestDTO pageRequestDTO) throws Exception {
        var pageSkeleton = new PageSkeleton();
        this.skeleton = this.shopify
                .withOfflineToken(AccessToken.token)
                .withHandles(pageRequestDTO.getHandles())
                .withShopName(pageRequestDTO.getShopName())
                .withPluckResponse("")
                .query(shopQuery, pageSkeleton);

        var formatPage = Arrays.stream(skeleton.getPages()).map(page -> {
            page.setUrl("https://" + shopify.getShopName() + "/pages/" + page.getHandle());
            return page;
        }).collect(Collectors.toList());

        HashMap<String, Object> pages = new HashMap<>();
        pages.put("pages", formatPage);
        return pages;
    }
}
