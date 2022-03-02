package com.wiloke.shopify.connection.dto.shopify.request.pluck;

import lombok.Getter;


@Getter
public enum ShopInfoPluck implements InfoPluckable {
    name("name", null, true, false),
    domains("domains", "host,id,sslEnabled,url", true, false),
    address("billingAddress", "city,company,country,province,provinceCode,zip,address1", true, false),
    id("id", null, true, false),
    email("email", null, true, false),
    description("description", null, true, false),
    primaryDomain("primaryDomain", "url,host", true, false),
    phone("billingAddress", "phone", true, false),
    money_with_currency_format("currencyFormats", "moneyWithCurrencyFormat", true, false),
    url("url", null, true, false),
    permanent_domain("myshopifyDomain", null, true, false),
    myshopifyDomain("myshopifyDomain", null, true, false),
    contactEmail("contactEmail", null, true, false),
    secureUrl("url", null, true, false),
    customer_accounts_enabled(null, null, false, false),//đang để cứng
    customer_accounts_optional(null, null, false, false),//đang để cứng
    collections_count(null, null, false, false),//đang để cứng
    metafields("metafields(first: 10)", "createdAt,description,id,key,legacyResourceId,namespace,type,updatedAt,value", true, true),
    currency("currencySettings(first: 5)", "rateUpdatedAt,enabled,currencyName,currencyCode", true, true),
    types("productTypes(first: 10)", null, true, true),
    vendors("productVendors(first: 10)", null, true, true),
    money_format("currencyFormats", "moneyFormat", true, false);


    private final String field;
    private final String subQuery;
    private final Boolean isDefault;
    private final Boolean hasEdges;

    ShopInfoPluck(String field, String subQuery, boolean isDefault, Boolean hasEdges) {
        this.field = field;
        this.subQuery = subQuery;
        this.isDefault = isDefault;
        this.hasEdges = hasEdges;
    }
}
