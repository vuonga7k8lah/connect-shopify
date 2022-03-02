package com.wiloke.shopify.connection.dto.shopify;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductsEdgesDTO {
    private List<ProductEdgesDTO> edges;
}
