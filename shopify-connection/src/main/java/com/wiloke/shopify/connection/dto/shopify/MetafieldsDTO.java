package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

import java.util.Date;

@Data
public class MetafieldsDTO {
    private Date createdAt;
    private Date updatedAt;
    private String description;
    private String id;
    private String key;
    private String legacyResourceId;
    private String type;
    private String value;
}
