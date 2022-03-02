package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class ShippingMethodDTO {
    private String handle;
    private Number original_price;
    private Number price;
    private String title;
}
