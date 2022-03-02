package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class PriceRangV2DTO {
    private MaxVariantPriceDTO maxVariantPrice;
    private MinVariantPrice minVariantPrice;
}
