package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class LocationDTO {
    private AddressDTO address;
    private Integer id;
    private Object latitude;
    private Object longitude;
    private String name;
}
