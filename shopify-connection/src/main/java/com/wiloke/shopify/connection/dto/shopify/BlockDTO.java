package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class BlockDTO {
    private Integer id;
    private SettingObjectDTO settings;
    private ShopifyAttributesDTO shopify_attributes;
    private String type;
}
