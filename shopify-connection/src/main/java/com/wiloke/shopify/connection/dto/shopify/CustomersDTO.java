package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

import java.util.Arrays;
import java.util.stream.Collectors;

@Data
public class CustomersDTO {
    private CustomerEdgesDTO customers;

    public Object getCustomers(){
        if (customers==null){
            return null;
        }
        return Arrays.stream(customers.getEdges()).map(CustomerNodeDTO::getNode).collect(Collectors.toList());
    }
}
