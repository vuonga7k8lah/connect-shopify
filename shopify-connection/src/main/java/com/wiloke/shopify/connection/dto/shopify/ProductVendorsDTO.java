package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

import java.util.List;

@Data
public class ProductVendorsDTO {
    private List<ProductVendorsEdgesDTO> edges;
}
