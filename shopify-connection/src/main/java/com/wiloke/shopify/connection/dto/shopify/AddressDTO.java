package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class AddressDTO {
    private String city;
    private String company;
    private String country;
    private String country_upper;
    private String province;
    private String province_code;
    private String street;
    private String summary;
    private String zip;
}
