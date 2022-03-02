package com.wiloke.shopify.connection.dto.shopify;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVariantsDTO {
    private ProductsPageInfoDTO pageInfo;
    private VariantsEdgesDTO[] edges;
}
