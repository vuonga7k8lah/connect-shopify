package com.wiloke.shopify.connection.dto.shopify;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductEdgesDTO {
    @Getter(AccessLevel.PRIVATE)
    private String cursor;
    private ProductDTO node;
}
