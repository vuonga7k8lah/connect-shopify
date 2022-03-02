package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiloke.shopify.connection.utils.TargetSelection;
import com.wiloke.shopify.connection.utils.TypeDiscountApplication;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscountApplicationDTO {
    private TargetSelection target_selection;
    private  String target_type;
    private String title;
    private Integer total_allocated_amount;
    private TypeDiscountApplication type;
    private Object value;
    //value_type: 'fixed_amount' | 'percentage';
}
