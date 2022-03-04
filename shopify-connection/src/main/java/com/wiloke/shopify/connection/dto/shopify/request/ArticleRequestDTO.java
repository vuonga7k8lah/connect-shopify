package com.wiloke.shopify.connection.dto.shopify.request;

import com.wiloke.shopify.connection.dto.shopify.request.pluck.ArticlePluck;
import com.wiloke.shopify.connection.utils.IdUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleRequestDTO extends DTORequestable<ArticlePluck> implements DTORequestByIdable {
    @NotNull(message = "The id is required!")
    @NotEmpty(message = "The id is required!")
    protected String id;

    @Override
    public ArticlePluck[] getAllPluck() {
        return new ArticlePluck[0];
    }

    @Override
    public DTORequestByIdable setId(String id) {
        this.id = id;

        return this;
    }

    public String getId() {
        return this.id;
    }
    private String handles;
}
