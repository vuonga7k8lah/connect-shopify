package com.wiloke.shopify.connection.dto.shopify.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentFakeDTO {
    private String author = "Soleone";
    private String content = "Hi author, I really _like_ what you're doing there.";
    private String created_at = "022-02-03T16:53:36-05:00";
    private String email = "sole@one.de";
    private Number id = 653537639;
    private String  status =  "unapproved";
    private String updated_at = "2022-02-03T16:53:36-05:00";
    private String url;
}
