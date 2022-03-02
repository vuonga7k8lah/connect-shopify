package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;
@Data
public class GiftCardDTO {
    public Number balance;
    public String code;
    public String currency;
    public CustomerDTO customer;
    public Boolean enabled;
    public Boolean expired;
    public String expires_on;
    public Object initial_value;
    public String last_four_characters;
    public LineItemDTO properties;
    public ProductDTO product;
    public String url;
}
