package com.wiloke.shopify.connection.repositories.skeleton;


import com.wiloke.shopify.connection.dto.shopify.CheckoutFakeDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CheckoutSkeleton {
    public Object getCheckouts() {
        return (new CheckoutFakeDTO());
    }
}
