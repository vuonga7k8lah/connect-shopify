package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class ThrottleStatusDTO {
    private int maximumAvailable;
    private int currentlyAvailable;
    private double restoreRate;
}
