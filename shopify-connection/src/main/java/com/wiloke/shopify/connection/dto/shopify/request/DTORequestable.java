package com.wiloke.shopify.connection.dto.shopify.request;

import com.wiloke.shopify.connection.dto.shopify.request.pluck.InfoPluckable;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public abstract class DTORequestable<T extends InfoPluckable> {
    private Boolean withQueryCost = false;

    @NotNull(message = "The shop name is required")
    private String shopName;

    private T[] pluck;

    private T[] defaultPluck;

    private String after;
    private String before;
    private Integer first;
    private Integer last;

    abstract public T[] getAllPluck();
}
