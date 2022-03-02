package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiloke.shopify.connection.utils.TypeDiscountApplication;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartFakeDTO {
    public Object getDiscount_applications() {
        var data = new DiscountApplicationDTO();
        data.setTitle("SUMMER16");
        data.setType(TypeDiscountApplication.DISCOUNT_CODE);
        data.setTotal_allocated_amount(20);
        data.setValue("SUMMER16");
        return data;
    }

    private Boolean taxes_included;
    private String attributes;

    public Object getCart_level_discount_applications() {
        var data = new ArrayList<>();
        data.add(getDiscount_applications());
        data.add(getDiscount_applications());
        return data;
    }

    private String currency = "CAD";
    private Number item_count = 3;

    public Object getItems() {
        var imageDTO = new ImageDTO();
        imageDTO.setAltText("Red rain coat with a hood");
        imageDTO.setWidth(300);
        imageDTO.setHeight(300);
        imageDTO.setUrl("http://cdn.shopify.com/s/files/1/0040/7092/products/red-rain-coat.jpeg?v=1402604893");

        var lineItems = new LineItemDTO();
        lineItems.setId("b721507a3fc9adfd");
        lineItems.setKey("794864229:03af7a8cb59a4c3c45595c76fa8cb53c");
        lineItems.setSku("IPOD2008RED");
        lineItems.setVendor("Shopify");
        lineItems.setTitle("Red Rain Coat - Small");
        lineItems.setGrams(0);
        lineItems.setFinal_line_price(12900);
        lineItems.setQuantity(1);
        lineItems.setFulfillment_service("manual");
        lineItems.setImage(imageDTO);
        var data = new ArrayList<>();
        data.add(lineItems);
        data.add(lineItems);
        return data;
    }

    private Number items_subtotal_price = 18200;
    private String note = "Hello!";
    private Number original_total_price = 18200;
    private Number total_discount = 200;
    private Number total_price = 9100;
    private Number total_weight = 0;
}
