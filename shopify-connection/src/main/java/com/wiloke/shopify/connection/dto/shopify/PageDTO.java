package com.wiloke.shopify.connection.dto.shopify;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class PageDTO {
    private String author;
    private String handle;
    private Number id;
    private String published_at;
    private String template_suffix;
    private String title;
    private String url;
    @Getter(AccessLevel.PRIVATE)
    private Number shop_id;
    @Getter(AccessLevel.PRIVATE)
    private String body_html;
    @Getter(AccessLevel.PRIVATE)
    private String created_at;
    @Getter(AccessLevel.PRIVATE)
    private String updated_at;
    @Getter(AccessLevel.PRIVATE)
    private String admin_graphql_api_id;
}
