package com.wiloke.shopify.connection.dto.shopify.request.pluck;

import lombok.Getter;

@Getter
public enum CustomerPluck implements InfoPluckable {
    first_name("firstName", null, true, false),
    last_name("lastName", null, true, false),
    phone("phone", null, true, false),
    tax_exempt(" taxExempt", null, true, false),
    id("id", null, true, false),
    accepts_marketing("acceptsMarketing", null, true, false),
    last_order("lastOrder", "email,name,note,phone,displayFulfillmentStatus,cancelledAt,totalShippingPrice,subtotalPrice,totalTax,totalPrice,totalDiscounts,totalRefunded,billingAddress {\n" +
            "            city\n" +
            "            company\n" +
            "            country\n" +
            "            province\n" +
            "            provinceCode\n" +
            "            zip\n" +
            "            address1\n" +
            "          },shippingAddress {\n" +
            "            city\n" +
            "            company\n" +
            "            country\n" +
            "            province\n" +
            "            provinceCode\n" +
            "            zip\n" +
            "            address1\n" +
            "          }", true, false),
    orders("orders(first: 4)", "email,name,note,phone,displayFulfillmentStatus,cancelledAt,totalShippingPrice,subtotalPrice,totalTax,totalPrice,totalDiscounts,totalRefunded,billingAddress {\n" +
            "            city\n" +
            "            company\n" +
            "            country\n" +
            "            province\n" +
            "            provinceCode\n" +
            "            zip\n" +
            "            address1\n" +
            "          },shippingAddress {\n" +
            "            city\n" +
            "            company\n" +
            "            country\n" +
            "            province\n" +
            "            provinceCode\n" +
            "            zip\n" +
            "            address1\n" +
            "          }, lineItems(first: 2) {\n" +
            "                edges {\n" +
            "                  node {\n" +
            "                    id\n" +
            "                    sku\n" +
            "                    title\n" +
            "                    quantity\n" +
            "                    vendor\n" +
            "                    requiresShipping\n" +
            "                    image {\n" +
            "                      altText\n" +
            "                      height\n" +
            "                      id\n" +
            "                      src\n" +
            "                      width\n" +
            "                      url\n" +
            "                    }\n" +
            "                  }\n" +
            "                }\n" +
            "              }", true, true),
    addresses("addresses", "address1,address2,city,company,country,countryCode,firstName,lastName,name,phone,province,provinceCode,zip", true, false),
    default_address("defaultAddress", "address1,address2,city,company,country,countryCode,firstName,lastName,name,phone,province,provinceCode,zip", true, false),
    total_spent("totalSpent", null, true, false),//Return String
    email("email", null, true, false);
    private final String field;
    private final String subQuery;
    private final Boolean isDefault;
    private final Boolean hasEdges;

    CustomerPluck(String field, String subQuery, boolean isDefault, Boolean hasEdges) {
        this.field = field;
        this.subQuery = subQuery;
        this.isDefault = isDefault;
        this.hasEdges = hasEdges;
    }
}
