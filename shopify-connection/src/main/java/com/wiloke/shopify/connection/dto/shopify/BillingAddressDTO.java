package com.wiloke.shopify.connection.dto.shopify;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;


@Data
public class BillingAddressDTO {
    private String phone;
    private String city;
    private String company;
    private String country;
    private String country_upper;
    public String getCountry_upper() {
        if (country == null) {
            return null;
        }
        return country.toUpperCase();
    }
    private String province;
    @Getter(AccessLevel.PRIVATE)
    private String provinceCode;
    private String province_code;
    public String getProvince_code() {
        if (provinceCode == null) {
            return null;
        }
        return provinceCode;
    }

    private String street;
    public String getStreet() {
        if (address1 == null) {
            return null;
        }
        return address1;
    }
    @Getter(AccessLevel.PRIVATE)
    private String address1;
    private String summary;
    private String zip;
}
