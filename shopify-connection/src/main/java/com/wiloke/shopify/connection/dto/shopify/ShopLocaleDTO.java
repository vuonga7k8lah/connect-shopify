package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class ShopLocaleDTO {
    private String iso_code;
    private String name;
    private Boolean primary;
    private String root_url;
}
