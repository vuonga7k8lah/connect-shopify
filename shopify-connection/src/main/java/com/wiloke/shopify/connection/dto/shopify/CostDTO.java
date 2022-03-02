package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class CostDTO {
    private int requestedQueryCost;
    private int actualQueryCost;
    private ThrottleStatusDTO throttleStatus;
}
