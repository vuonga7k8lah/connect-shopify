//package com.wiloke.shopify.connection.services.impl;
//
//import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
//import com.wiloke.shopify.connection.repositories.Shopify;
//import com.wiloke.shopify.connection.repositories.query.ShopifyQueryAble;
//import com.wiloke.shopify.connection.repositories.skeleton.ShopLocalesSkeleton;
//import com.wiloke.shopify.connection.repositories.skeleton.ShopSkeleton;
//import com.wiloke.shopify.connection.services.ShopifyServiceAble;
//import com.wiloke.shopify.connection.utils.APIUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//@Service(value = "ShopLocaleServiceImpl")
//public class ShopLocaleServiceImpl implements ShopifyServiceAble {
//
//    @Autowired
//    private Shopify shopify;
//
//    @Autowired
//    @Qualifier(value = "ShopLocalesQuery")
//    private ShopifyQueryAble shopQuery;
//
//    @Autowired
//    private ShopLocalesSkeleton shopLocalesSkeleton;
//
//    //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
//    //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
//    private final String offlineToken = "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";
//
//    @Override
//    public Object getAll(String shopName) throws Exception {
//        var shopInfo = this.getData(shopName);
//        var queryCost = this.getQueryCost();
//
//        return APIUtil.buildFullResponse(shopInfo, queryCost);
//    }
//
//    @Override
//    public Object getData(String shopName) throws Exception {
//        this.shopLocalesSkeleton =  this.shopify.withOfflineToken(this.offlineToken).withShopName(shopName).query(shopQuery, this.shopLocalesSkeleton);
//        return shopLocalesSkeleton.getData();
//    }
//
//    @Override
//    public QueryCostDTO getQueryCost() {
//        return this.shopLocalesSkeleton.getExtensions();
//    }
//}
