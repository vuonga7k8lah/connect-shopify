package com.wiloke.shopify.connection.dto.shopify;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsPageInfoDTO {
    private boolean hasNextPage;
    private boolean hasPreviousPage;
}
