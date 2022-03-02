package com.wiloke.shopify.connection.dto.shopify.request;

import com.wiloke.shopify.connection.dto.shopify.request.pluck.BlogPluck;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BlogRequestDTO extends DTORequestable<BlogPluck>{
    @Override
    public BlogPluck[] getAllPluck() {
        return new BlogPluck[0];
    }
}
