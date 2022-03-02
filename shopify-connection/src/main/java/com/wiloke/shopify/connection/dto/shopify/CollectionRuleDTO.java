package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class CollectionRuleDTO {
    private String column;
    private String condition;
    private String relation;
}
