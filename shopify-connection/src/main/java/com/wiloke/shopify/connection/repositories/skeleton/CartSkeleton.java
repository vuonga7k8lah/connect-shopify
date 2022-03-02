package com.wiloke.shopify.connection.repositories.skeleton;

import com.wiloke.shopify.connection.dto.shopify.CartFakeDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CartSkeleton {
    public Object getCarts(){
        return (new CartFakeDTO());
    }
}
