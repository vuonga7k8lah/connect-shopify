package com.wiloke.shopify.connection.dto.shopify.request;

import com.wiloke.shopify.connection.dto.shopify.request.pluck.CollectionPluck;
import com.wiloke.shopify.connection.utils.IdUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

public class CollectionRequestDTO extends DTORequestable<CollectionPluck> implements DTORequestByIdable {
    @NotNull(message = "The id is required!")
    @NotEmpty(message = "The id is required!")
    private String id;

    @Override
    public CollectionPluck[] getAllPluck() {
        return  Arrays.stream(CollectionPluck.values()).filter(pluck->pluck.getIsDefault().equals(true)).toArray(CollectionPluck[]::new);
    }

    @Override
    public DTORequestByIdable setId(String id) {
        this.id = IdUtils.addShopifyIDPrefix(id);

        return this;
    }

    public String getId() {
        return this.id;
    }
}
