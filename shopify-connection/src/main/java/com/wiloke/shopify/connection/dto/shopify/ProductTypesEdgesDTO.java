package com.wiloke.shopify.connection.dto.shopify;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class ProductTypesEdgesDTO {
    private String node;
    @Getter(AccessLevel.PRIVATE)
    private String cursor;
}
