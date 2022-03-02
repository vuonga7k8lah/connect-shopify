package com.wiloke.shopify.connection.dto.shopify.request.pluck;

import lombok.Getter;

@Getter
public enum ProductPluck implements InfoPluckable {
    title("title", null, true, false),
    featured_image("featuredImage", "altText,id,height,src,width,url", true,false),
    options("options", "values,name", true,false),
    handle("handle", null, true, false),
    available(null, null, false, false),//default return true
    id("id", null, true, false),
    type("productType", null, true, false),
    vendor("vendor", null, true, false),
    tags("tags", null, true, false),
    created_at("createdAt", null, true, false),
    published_at("publishedAt", null, true, false),
    content("bodyHtml", null, true, false),
    media("media(first: 5)", "alt,mediaContentType,preview {\n" +
            "                image {\n" +
            "                  id\n" +
            "                  height\n" +
            "                  altText\n" +
            "                  src\n" +
            "                  url\n" +
            "                  width\n" +
            "                }\n" +
            "              }", true, true),
    compare_at_price("variants(first: 5)", "compareAtPrice", false, true),
    compare_at_price_max("variants(first: 5)", "compareAtPrice", false, true),
    compare_at_price_min("variants(first: 5)", "compareAtPrice", false, true),
    compare_at_price_varies("variants(first: 5)", "compareAtPrice", false, true),
    variants("variants(first: 5)", "id\n" +
            "              title\n" +
            "              price\n" +
            "              compareAtPrice\n" +
            "              barcode\n" +
            "              inventoryManagement\n" +
            "              requiresShipping\n" +
            "              sku\n" +
            "              weight", true, true),
    images("images(first: 5)", "altText,id,height,src,width,url", true, true),
    collections("collections(first: 4)", "id\n" +
            "              handle\n" +
            "              updatedAt\n" +
            "              image {\n" +
            "                width\n" +
            "                height\n" +
            "                altText\n" +
            "                src\n" +
            "              }", true, true),
    description("descriptionHtml", null, true, false),
    price_max("priceRangeV2", "maxVariantPrice {\n" +
            "            amount\n" +
            "          }\n" +
            "          minVariantPrice {\n" +
            "            amount\n" +
            "          }", true, false),
    price_min("priceRangeV2", "maxVariantPrice {\n" +
            "            amount\n" +
            "          }\n" +
            "          minVariantPrice {\n" +
            "            amount\n" +
            "          }", false, false),
    price_varies("priceRangeV2", "maxVariantPrice {\n" +
            "            amount\n" +
            "          }\n" +
            "          minVariantPrice {\n" +
            "            amount\n" +
            "          }", false, false),
    price("priceRangeV2", "maxVariantPrice {\n" +
            "            amount\n" +
            "          }\n" +
            "          minVariantPrice {\n" +
            "            amount\n" +
            "          }", false, false);
    private final String field;
    private final String subQuery;
    private final Boolean isDefault;
    private final Boolean hasEdges;

    ProductPluck(String field, String subQuery, boolean isDefault, Boolean hasEdges) {
        this.field = field;
        this.subQuery = subQuery;
        this.isDefault = isDefault;
        this.hasEdges = hasEdges;
    }
}
