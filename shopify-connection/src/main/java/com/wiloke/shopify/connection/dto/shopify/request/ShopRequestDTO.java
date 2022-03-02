package com.wiloke.shopify.connection.dto.shopify.request;

import com.wiloke.shopify.connection.dto.shopify.request.pluck.OrderPluck;
import com.wiloke.shopify.connection.dto.shopify.request.pluck.ShopInfoPluck;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;

@EqualsAndHashCode(callSuper = true)
@Data
public class ShopRequestDTO extends DTORequestable<ShopInfoPluck> {

    @Override
    public ShopInfoPluck[] getAllPluck() {
        return  Arrays.stream(ShopInfoPluck.values()).filter(pluck->pluck.getIsDefault().equals(true)).toArray(ShopInfoPluck[]::new);
    }
}
