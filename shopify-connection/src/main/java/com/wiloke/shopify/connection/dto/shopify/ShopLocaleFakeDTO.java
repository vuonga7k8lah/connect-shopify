package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class ShopLocaleFakeDTO {
    private String locale = "en";
    private Boolean enabled = true;
    private Boolean primary = true;
    private Boolean published = true;
}
