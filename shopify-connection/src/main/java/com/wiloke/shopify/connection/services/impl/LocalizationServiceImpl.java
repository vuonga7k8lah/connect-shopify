package com.wiloke.shopify.connection.services.impl;

import com.wiloke.shopify.connection.repositories.skeleton.LocalizationSkeleton;
import com.wiloke.shopify.connection.services.ShopifyServiceFakeAble;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Data
@Service(value = "LocalizationServiceImpl")
public class LocalizationServiceImpl implements ShopifyServiceFakeAble {
    @Autowired
    private LocalizationSkeleton localizationSkeleton;

    @Override
    public Object getData() throws Exception {
        HashMap<String, Object> comment = new HashMap<>();
        comment.put("localization", localizationSkeleton.getData());
        return comment;
    }
}
