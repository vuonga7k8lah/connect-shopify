package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class LanguageFakeDTO {
    public Object getShop_locale(){
        return new ShopLocaleFakeDTO();
    }
}
