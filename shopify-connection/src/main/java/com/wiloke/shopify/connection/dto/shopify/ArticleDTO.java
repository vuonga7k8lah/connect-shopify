package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleDTO {
    private String body_html;
    private Number blog_id;
    private Number user_id;
    private String summary_html;
    private String template_suffix;
    @Getter(AccessLevel.PRIVATE)
    private String admin_graphql_api_id;

    // Docs có nhưng thực tế có thể có hoặc không
//    comment_post_url?:string;
    //private Arrays comments = ;//
    private Number comments_count = 0;
    private Boolean comments_enabled = true;
//    content?:string;
//    excerpt?:string;
//    excerpt_or_content?:string;
//    moderated?:boolean;
//    url?:string;
//    user?:UserObject;

    // Docs
    private String author;
    private String created_at;
    private String handle;
    private Number id;
    private ImageDTO image;
    private String published_at;
    private String tags;
    private String title;
    private String updated_at;
}
