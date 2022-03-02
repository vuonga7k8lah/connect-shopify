package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

import java.util.List;

@Data
public class CartDTO {
    //discount_applications?: DiscountApplication[];
    //taxes_included?: boolean;

    //attributes: Record<string, any>;
    //cart_level_discount_applications: DiscountApplication[];
    private String currency;
    private Integer item_count;
    private List<LineItemDTO> items;
    private Integer items_subtotal_price;
    private String  note;
    private Integer original_total_price;
    private Integer total_discount;
    private Integer total_price;
    private Integer total_weight;
}
