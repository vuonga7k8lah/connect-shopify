package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerAddressDTO {
    private String address1;
    private String address2;
    private String city;
    private String company;
    private String country;
    private String country_code;

    public String getCountry_code() {
        if (countryCode == null) {
            return null;
        }
        return countryCode;
    }

    @Getter(AccessLevel.PRIVATE)
    private String countryCode;
    private String first_name;

    public String getFirst_name() {
        if (firstName == null) {
            return null;
        }
        return firstName;
    }

    @Getter(AccessLevel.PRIVATE)
    private String firstName;
    private String id;
    private String last_name;

    public String getLast_name() {
        if (lastName == null) {
            return null;
        }
        return lastName;
    }

    @Getter(AccessLevel.PRIVATE)
    private String lastName;
    private String name;
    private String phone;
    private String province;
    private String province_code;

    public String getProvince_code() {
        if (provinceCode == null) {
            return null;
        }
        return provinceCode;
    }

    @Getter(AccessLevel.PRIVATE)
    private String provinceCode;
    private String street;

    public String getStreet() {
        return getAddress1() + ", " + getAddress2();
    }

    private String zip;
}
