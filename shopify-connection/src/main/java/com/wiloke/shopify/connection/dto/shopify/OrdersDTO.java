package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class OrdersDTO {
    private OrderNodeDTO[] edges;
}
