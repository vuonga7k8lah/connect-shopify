package com.wiloke.shopify.connection.graphqlbuilder;

import com.wiloke.shopify.connection.dto.shopify.request.DTORequestable;

public interface GraphqlBuilderable<T extends DTORequestable>{
    GraphqlBuilderable<T> setRequest(T queryable);

    String build();
}
