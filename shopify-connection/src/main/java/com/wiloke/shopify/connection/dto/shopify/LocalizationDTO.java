package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

import java.util.List;

@Data
public class LocalizationDTO {
    private String country;
    private List<String> alternateLocales;
    private String defaultLocale;
}
