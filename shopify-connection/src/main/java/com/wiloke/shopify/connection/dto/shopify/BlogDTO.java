package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlogDTO {
    private String all_tags;

    public String getAll_tags() {
        if (tags == null) {
            return null;
        }
        return getTags();
    }

    private Object articles;
    private Integer articles_count;
    private Boolean comments_enabled;

    public Boolean getComments_enabled() {
        if (commentable == null) {
            return null;
        }
        return !commentable.equals("no");
    }

    private String handle;
    private Number id;
    private Boolean moderated;

    public Boolean getModerated() {
        if (commentable == null) {
            return null;
        }
        return !commentable.equals("no");
    }

    @Getter(AccessLevel.PRIVATE)
    private String commentable;
    @Getter(AccessLevel.PRIVATE)
    private String updated_at;
    @Getter(AccessLevel.PRIVATE)
    private String feedburner;
    @Getter(AccessLevel.PRIVATE)
    private String feedburner_location;
    @Getter(AccessLevel.PRIVATE)
    private String template_suffix;
    @Getter(AccessLevel.PRIVATE)
    private String admin_graphql_api_id;
    @Getter(AccessLevel.PRIVATE)
    private String created_at;
    private ArticleDTO next_article;
    private ArticleDTO previous_article;
    private String tags;
    private String title;
    private String url = "";
}
