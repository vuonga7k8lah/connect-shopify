package com.wiloke.shopify.connection.dto.shopify;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;


@Data
public class CollectionImageDTO {
    private String alt;
    public String getAlt() {
        if (this.getAltText() == null) {
            return null;
        }
        return this.getAltText();
    }

    @Getter(AccessLevel.PRIVATE)
    private String altText;

    private Integer height;
    @Getter(AccessLevel.PRIVATE)
    public String id;
    private Integer width;
    private String src;
}
