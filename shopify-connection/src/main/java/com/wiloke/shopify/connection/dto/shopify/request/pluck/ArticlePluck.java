package com.wiloke.shopify.connection.dto.shopify.request.pluck;

import lombok.Getter;

@Getter

public enum ArticlePluck implements InfoPluckable {
    email("email", null, true, false);
    private final String field;
    private final String subQuery;
    private final Boolean isDefault;
    private final Boolean hasEdges;

    ArticlePluck(String field, String subQuery, boolean isDefault, Boolean hasEdges) {
        this.field = field;
        this.subQuery = subQuery;
        this.isDefault = isDefault;
        this.hasEdges = hasEdges;
    }
}
