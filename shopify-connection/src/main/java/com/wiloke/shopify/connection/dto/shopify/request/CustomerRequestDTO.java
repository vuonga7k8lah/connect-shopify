package com.wiloke.shopify.connection.dto.shopify.request;


import com.wiloke.shopify.connection.dto.shopify.request.pluck.CustomerPluck;


import java.util.Arrays;



public class CustomerRequestDTO extends DTORequestable<CustomerPluck>{
    @Override
    public CustomerPluck[] getAllPluck() {
        return  Arrays.stream(CustomerPluck.values()).filter(pluck->pluck.getIsDefault().equals(true)).toArray(CustomerPluck[]::new);
    }
}
