package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class CurrencyDTO {
    private String rateUpdatedAt;
    private String enabled;
    private String currencyName;
    private String currencyCode;
}
