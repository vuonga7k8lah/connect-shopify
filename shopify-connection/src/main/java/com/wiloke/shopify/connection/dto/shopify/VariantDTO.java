package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiloke.shopify.connection.utils.InventoryPolicyEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VariantDTO {
    // Thực tế có thêm
    private String name;
    private String public_title;
    private ImageDTO featured_image;

    // Theo docs thì có nhưng thực tế đang là không có
    private MediaDTO featured_media;
    private ImageDTO image;
    private Boolean incoming;
    private InventoryPolicyEnum inventory_policy;
    private Number inventory_quantity;
    protected Date next_incoming_date;
    private Boolean requires_selling_plan;
    //    selected_selling_plan_allocation?:SellingPlanAllocation;
//    selling_plan_allocations?:SellingPlanAllocation[] |null;
//    product?:Product;
    private Boolean selected;
    private String unit_price;
    private String unit_price_measurement;
    private String url;
    private String weight_unit;
    private String weight_in_unit;

    // Theo docs
    private Boolean available;
    private String barcode;
    private String compare_at_price;

    public String getCompare_at_price() {
        if (compareAtPrice == null) {
            return null;
        }
        return compareAtPrice;
    }

    @Getter(AccessLevel.PRIVATE)
    private String compareAtPrice;
    private String id;
    private Object inventory_management;
    public Object getInventory_management(){
        if (inventoryManagement == null){
            return null;
        }
        return inventoryManagement;
    }
    @Getter(AccessLevel.PRIVATE)
    private Object inventoryManagement;
    private Boolean matched;
    protected Object[] options;
    private Object option1;
    private Object option2;
    private Object option3;
    private Number price;
    private Boolean requires_shipping;
    public Boolean getRequires_shipping(){
        if (requiresShipping==null){
            return null;
        }
        return requiresShipping;
    }
    @Getter(AccessLevel.PRIVATE)
    private Boolean requiresShipping;
    private String sku;
    private Boolean store_availabilities;
    private Boolean taxable;
    private String title;
    private Number weight;
}
