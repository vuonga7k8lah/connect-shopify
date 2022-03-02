package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class CollectionRuleSetDTO {
    private Boolean appliedDisjunctively;
    private CollectionRuleDTO[] rules;
}
