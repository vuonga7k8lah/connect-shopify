package com.wiloke.shopify.connection.dto.shopify.request.pluck;

import lombok.Getter;

@Getter
public enum OrderPluck implements InfoPluckable {
    email("email", null, true, false),
    name("name", null, true, false),
    note("note", null, true, false),
    phone("phone", null, true, false),
    fulfillment_status("displayFulfillmentStatus", null, true, false),
    financial_status_label("displayFinancialStatus", null, true, false),
    cancelled_at("cancelledAt", null, true, false),
    order_number("name", null, true, false),
    shipping_price("totalShippingPrice", null, true, false),
    subtotal_price("subtotalPrice", null, true, false),
    tax_price("totalTax", null, true, false),
    total_price("totalPrice", null, true, false),
    total_discounts("totalDiscounts", null, true, false),
    total_refunded_amount("totalRefunded", null, true, false),
    transactions("transactions", "id,gateway,createdAt,amount,status,kind,receipt,formattedGateway", true, false),
    total_net_amount("totalRefunded,totalPrice", null, true, false),
    tax_lines("taxLines", "price,rate,title,ratePercentage", true, false),
    cancelled("cancelledAt", null, true, false),
    created_at("createdAt", null, true, false),
    financial_status("displayFinancialStatus", null, true, false),
    billing_address("billingAddress", "city,company,country,province,provinceCode,zip,address1", true, false),
    shipping_address("shippingAddress", "city,company,country,province,provinceCode,zip,address1", true, false),
    line_items("lineItems(first: 10)", "id,title,quantity,sku,vendor,requiresShipping,image {\n" +
            "                      altText\n" +
            "                      height\n" +
            "                      id\n" +
            "                      src\n" +
            "                      width\n" +
            "                      url\n" +
            "                    },", false, true);
    private final String field;
    private final String subQuery;
    private final Boolean isDefault;
    private final Boolean hasEdges;

    OrderPluck(String field, String subQuery, boolean isDefault, Boolean hasEdges) {
        this.field = field;
        this.subQuery = subQuery;
        this.isDefault = isDefault;
        this.hasEdges = hasEdges;
    }
}
