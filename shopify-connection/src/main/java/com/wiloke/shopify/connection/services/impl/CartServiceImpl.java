package com.wiloke.shopify.connection.services.impl;

import com.wiloke.shopify.connection.repositories.skeleton.CartSkeleton;
import com.wiloke.shopify.connection.services.ShopifyServiceFakeAble;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@Service(value = "CartServiceImpl")
public class CartServiceImpl implements ShopifyServiceFakeAble {
    @Autowired
    private CartSkeleton cartSkeleton;

    @Override
    public Object getData() throws Exception {
        HashMap<String, Object> carts = new HashMap<>();
        var listCarts = new ArrayList<>();
        listCarts.add(cartSkeleton.getCarts());
        listCarts.add(cartSkeleton.getCarts());
        listCarts.add(cartSkeleton.getCarts());
        listCarts.add(cartSkeleton.getCarts());
        listCarts.add(cartSkeleton.getCarts());
        carts.put("carts", listCarts);
        return carts;
    }
}
