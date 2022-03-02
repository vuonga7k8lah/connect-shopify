package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollectionNodeDTO {
    private CollectionDTO node;
    private String handle;
    private CollectionRuleSetDTO ruleSet;
    private CollectionImageDTO image;
}
