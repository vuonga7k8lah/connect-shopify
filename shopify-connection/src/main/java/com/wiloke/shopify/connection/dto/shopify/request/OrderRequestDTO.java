package com.wiloke.shopify.connection.dto.shopify.request;

import com.wiloke.shopify.connection.dto.shopify.request.pluck.CustomerPluck;
import com.wiloke.shopify.connection.dto.shopify.request.pluck.OrderPluck;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderRequestDTO extends DTORequestable<OrderPluck> {
    @Override
    public OrderPluck[] getAllPluck() {
        return  Arrays.stream(OrderPluck.values()).filter(pluck->pluck.getIsDefault().equals(true)).toArray(OrderPluck[]::new);
    }
}
