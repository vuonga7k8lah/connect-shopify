package com.wiloke.shopify.connection.dto.shopify.request.pluck;

import lombok.Getter;

@Getter
public enum CollectionPluck implements InfoPluckable {
    image("image", "altText,id,height,src,width", true),
    id("id", null, true),
    description("description", null, true),
    handle("handle", null, true),
    products_count("productsCount", null, false),
    all_products_count("productsCount", null, true),
    all_tags("ruleSet", "rules {\n" +
            "        column\n" +
            "        condition\n" +
            "        relation\n" +
            "      }", true),
    all_types("products(first: 20)", "edges {\n" +
            "        cursor\n" +
            "        node {\n" +
            "          productType\n" +
            "        }\n" +
            "      }", false), // Lấy max 20 sản phẩm
    all_vendors("products(first: 20)", "edges {\n" +
            "        cursor\n" +
            "        node {\n" +
            "          vendor\n" +
            "        }\n" +
            "      }", false), // Lấy max 20 sản phẩm
    default_sort_by(null, null, false), // Đang để cứng
    sort_by(null, null, false), // Đang để cứng
    sort_options(null, null, false), // Đang để cứng
    featured_image("image", "id\n" + // Xem thêm tại ImageDTO
            "      altText\n" +
            "      url\n" +
            "      height\n" +
            "      width\n" +
            "      metafields(first: 1) {\n" +
            "        edges {\n" +
            "          node {\n" +
            "            createdAt\n" +
            "            id\n" +
            "          }\n" +
            "        }\n" +
            "      }", false),
    next_product("products(first: 20)", "pageInfo {\n" + // cái này a check hasNextPage === true => fake data
            "        hasNextPage\n" +
            "      }", false),
    previous_product("products(first: 20)", "pageInfo {\n" + // cái này a check hasNextPage === true => fake data
            "        hasPreviousPage\n" +
            "      }", false),
    products("products(first: 20)", "edges {\n" +
            "        node {\n" +
            "          productType\n" +
            "          vendor\n" +
            "          title\n" +
            "          variants(first: 1) {\n" +
            "            pageInfo {\n" +
            "              hasNextPage\n" +
            "              hasPreviousPage\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      }", true),
    updated_at("updatedAt", null, true),
    url("handle", null, true),
    template_suffix("templateSuffix", null, true),
    published_at("updatedAt", null, false), // K có published_at, dùng updated_at cho lẹ
    body_html("descriptionHtml", null, true),
//    disjunctive(null, null, false), // chỗ này a không có thấy ở https://shopify.dev/api/liquid/objects/collection
//    rules(null, null, false), // chỗ này a không có thấy ở https://shopify.dev/api/liquid/objects/collection
//    published_scope(null, null, false), // chỗ này a không có thấy ở https://shopify.dev/api/liquid/objects/collection
    title("title", null, true);

    private String field;
    private String subQuery;
    private Boolean isDefault;

    CollectionPluck(String field, String subQuery, boolean isDefault) {
        this.field = field;
        this.subQuery = subQuery;
        this.isDefault = isDefault;
    }

}
