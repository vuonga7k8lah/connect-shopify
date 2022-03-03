package com.wiloke.shopify.connection.services.impl;

import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;

import com.wiloke.shopify.connection.dto.shopify.request.CustomerRequestDTO;
import com.wiloke.shopify.connection.graphqlbuilder.CustomerQueryBuilder;
import com.wiloke.shopify.connection.repositories.Shopify;
import com.wiloke.shopify.connection.repositories.query.ShopifyQueryable;
import com.wiloke.shopify.connection.repositories.skeleton.CustomerSkeleton;
import com.wiloke.shopify.connection.services.ShopifyServiceAble;
import com.wiloke.shopify.connection.utils.APIUtil;
import com.wiloke.shopify.connection.utils.AccessToken;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Data
@Service(value = "CustomerServiceImpl")
public class CustomerServiceImpl implements ShopifyServiceAble<CustomerRequestDTO> {
    @Autowired
    private Shopify shopify;

    @Autowired
    @Qualifier(value = "CustomerQuery")
    private ShopifyQueryable shopQuery;

    private CustomerSkeleton skeleton;

    private final String offlineToken = "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";

    @Override
    public QueryCostDTO getQueryCost() {
        return null;
    }

    @Autowired
    private CustomerQueryBuilder customerQueryBuilder;

    @Override
    public Object getData(CustomerRequestDTO customerRequestDTO) throws Exception {
        var customerSkeleton = new CustomerSkeleton();
        this.skeleton = this.shopify
                .withOfflineToken(AccessToken.token)
                .withShopName(customerRequestDTO.getShopName())
                .withPluckResponse(this.customerQueryBuilder.setRequest(customerRequestDTO).build())
                .query(shopQuery, customerSkeleton);

        //        if (customerRequestDTO.getWithQueryCost()) {
//            var queryCost = this.getQueryCost();
//            return APIUtil.buildFullResponse(data, queryCost);
//        }
        var customerData = skeleton.getData().getCustomers();
        var formatData = new HashMap<String, Object>();
        formatData.put("customer", customerData);
        return formatData;
    }
}
