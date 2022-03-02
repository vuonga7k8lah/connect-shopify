package com.wiloke.shopify.connection.dto.shopify.request;

import com.wiloke.shopify.connection.dto.shopify.request.pluck.PagePluck;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageRequestDTO extends DTORequestable<PagePluck>{
    @Override
    public PagePluck[] getAllPluck() {
        return new PagePluck[0];
    }
}
