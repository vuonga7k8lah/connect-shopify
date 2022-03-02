package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiloke.shopify.connection.utils.IdUtils;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LineItemDTO {
    //discount_allocations: DiscountAllocation[];
    private Integer final_line_price;
    //fulfillment: Fulfillment;
    private Object fulfillment_service;
    private Boolean gift_card;
    private Integer grams;
    private String id;

    public String getId() {
        if (id == null) {
            return null;
        }
        return IdUtils.removeStringFromId(id);
    }

    private ImageDTO image;
    private String key;

    public String getKey() {
        if (id == null) {
            return null;
        }
        return getId();
    }

    //line_level_discount_allocations: DiscountAllocation;
    private Integer line_level_total_discount = 0;//default
    private String message;
    //options_with_values: Option[];
    private Integer original_line_price;
    private Integer original_price;
    //product: Product;
    //product_id: Exclude<Product, null>['id'];
    //properties: Record<string, any>;
    private Number quantity;
    private Boolean requires_shipping;

    public Boolean getRequires_shipping() {
        if (requiresShipping == null) {
            return null;
        }
        return getRequiresShipping();
    }

    @Getter(AccessLevel.PRIVATE)
    private Boolean requiresShipping;
    //selling_plan_allocation: SellingPlanAllocation;
    private Object sku;
    private Boolean taxable = false;//đang để default
    private String title;
    private String unit_price = null;//Unit prices are available only to stores located in Germany or France.
    //unit_price_measurement: UnitPriceMeasurement;
    private String url;
    private String url_to_remove;
    //variant: Variant;
    //variant_id: Exclude<Variant, null>['id'];
    private String vendor;
}
