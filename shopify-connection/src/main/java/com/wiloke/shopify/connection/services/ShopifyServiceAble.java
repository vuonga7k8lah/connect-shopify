package com.wiloke.shopify.connection.services;

import com.wiloke.shopify.connection.dto.shopify.request.DTORequestable;
import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;

public interface ShopifyServiceAble<T extends DTORequestable> {
    QueryCostDTO getQueryCost();
    Object getData(T dtoRequestable) throws Exception;
}
