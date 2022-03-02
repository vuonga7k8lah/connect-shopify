package com.wiloke.shopify.connection.dto.shopify;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CollectionProductsDTO {
    private List<CollectionProductNodeDTO> edges;
    private ProductsPageInfoDTO pageInfo;
}
