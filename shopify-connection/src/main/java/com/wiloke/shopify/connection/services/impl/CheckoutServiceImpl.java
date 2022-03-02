package com.wiloke.shopify.connection.services.impl;

import com.wiloke.shopify.connection.repositories.skeleton.CheckoutSkeleton;
import com.wiloke.shopify.connection.services.ShopifyServiceFakeAble;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@Service(value = "CheckoutServiceImpl")
public class CheckoutServiceImpl implements ShopifyServiceFakeAble {
    @Autowired
    private CheckoutSkeleton checkoutSkeleton;

    @Override
    public Object getData() throws Exception {
        HashMap<String, Object> checkout = new HashMap<>();
        var listCheckouts = new ArrayList<>();
        listCheckouts.add(checkoutSkeleton.getCheckouts());
        listCheckouts.add(checkoutSkeleton.getCheckouts());
        listCheckouts.add(checkoutSkeleton.getCheckouts());
        listCheckouts.add(checkoutSkeleton.getCheckouts());
        listCheckouts.add(checkoutSkeleton.getCheckouts());
        checkout.put("checkouts", listCheckouts);
        return checkout;
    }
}
