package com.wiloke.shopify.connection.dto.shopify;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollectionProductNodeDTO {
    private String cursor;
    private ProductDTO node;
}
