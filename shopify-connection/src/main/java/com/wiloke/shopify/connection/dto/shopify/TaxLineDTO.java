package com.wiloke.shopify.connection.dto.shopify;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class TaxLineDTO {
    private String price;
    public Number getPrice(){
        if (price==null){
            return null;
        }
        return Integer.valueOf(price);
    }
    private Number rate;
    private Number rate_percentage;
    public Number getRate_percentage(){
        if (ratePercentage==null){
            return null;
        }
        return ratePercentage;
    }
    @Getter(AccessLevel.PRIVATE)
    private Number ratePercentage;
    private String title;
}
