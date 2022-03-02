package com.wiloke.shopify.connection.dto.shopify;

import lombok.AccessLevel;
import lombok.Getter;

public class TestCollectionImage {
    private String id;

    @Getter(AccessLevel.PRIVATE)
    private String altText;

    private String alt;

    public String getAlt() {
        return this.getAltText();
    }
}
