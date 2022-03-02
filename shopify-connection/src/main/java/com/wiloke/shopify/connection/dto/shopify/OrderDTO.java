package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiloke.shopify.connection.utils.CancelReasonEnum;
import com.wiloke.shopify.connection.utils.TypeDiscountApplication;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    //attributes: Record<string, any>;
    private AddressDTO billing_address;

    public BillingAddressDTO getBilling_address() {
        if (billingAddress == null) {
            return null;
        }
        return billingAddress;
    }

    @Getter(AccessLevel.PRIVATE)
    private BillingAddressDTO billingAddress;
    private Boolean cancelled;

    public Boolean getCancelled() {
        return cancelled_at != null;
    }

    private String cancelled_at;

    public String getCancelled_at() {
        if (cancelled_at == null) {
            return null;
        }
        return getCancelledAt();
    }

    private Enum<CancelReasonEnum> cancel_reason;
    private String cancel_reason_label;
    public Object getCart_level_discount_applications() {
        var data = new ArrayList<>();
        data.add(getDiscount_applications());
        data.add(getDiscount_applications());
        return data;
    }
    private String created_at;

    public String getCreated_at() {
        if (createdAt == null) {
            return null;
        }
        return getCreatedAt();
    }

    @Getter(AccessLevel.PRIVATE)
    private String createdAt;
    @Getter(AccessLevel.PRIVATE)
    private String cancelledAt;
    private CustomerDTO customer;
    private String customer_url = null;//default
    public Object getDiscount_applications() {
        var data = new DiscountApplicationDTO();
        data.setTitle("SUMMER16");
        data.setType(TypeDiscountApplication.DISCOUNT_CODE);
        data.setTotal_allocated_amount(20);
        data.setValue("SUMMER16");
        return data;
    }
    private String email;
    private String financial_status;

    public String getFinancial_status() {
        if (displayFinancialStatus == null) {
            return null;
        }
        return getDisplayFinancialStatus();
    }

    private String financial_status_label;

    public String getFinancial_status_label() {
        if (displayFinancialStatus == null) {
            return null;
        }
        return getDisplayFinancialStatus().toLowerCase(Locale.ROOT);
    }

    @Getter(AccessLevel.PRIVATE)
    private String displayFinancialStatus;
    private String fulfillment_status;

    public String getFulfillment_status() {
        if (displayFulfillmentStatus == null) {
            return null;
        }
        return getDisplayFulfillmentStatus().toLowerCase(Locale.ROOT);
    }

    @Getter(AccessLevel.PRIVATE)
    private String displayFulfillmentStatus;
    private String fulfillment_status_label;
    private LineItemsDTO[] line_items;

    public Object getLine_items() {
        if (lineItems == null) {
            return null;
        }
        if (lineItems.getEdges() == null) {
            return null;
        }
        return Arrays.stream(lineItems.getEdges()).map(LineItemNodeDTO::getNode).collect(Collectors.toList());
    }

    @Getter(AccessLevel.PRIVATE)
    private LineItemsDTO lineItems;
    private Integer line_items_subtotal_price;
    private LocationDTO location;
    private String name;
    private String note;
    private Number order_number;

    public Number getOrder_number() {
        if (name == null) {
            return null;
        }
        return Integer.valueOf(name.replace("#", ""));
    }

    private OrderDTO order_status_url;
    private Object payment_terms = null;
    private String phone;
    private BillingAddressDTO shipping_address;

    public BillingAddressDTO getShipping_address() {
        if (shippingAddress == null) {
            return null;
        }
        return getShippingAddress();
    }

    @Getter(AccessLevel.PRIVATE)
    private BillingAddressDTO shippingAddress;

    public Object getShipping_methods() {
        var shipping = new ShippingMethodDTO();
        shipping.setHandle("shopify-international-shipping-25.00");
        shipping.setTitle("International Shipping");
        shipping.setPrice(15);
        shipping.setOriginal_price(20);

        var listShipping = new ArrayList<>();
        listShipping.add(shipping);
        listShipping.add(shipping);
        return listShipping;
    }

    private Number shipping_price;

    public Number getShipping_price() {
        if (totalShippingPrice == null) {
            return null;
        }
        return Integer.valueOf(totalShippingPrice);
    }

    @Getter(AccessLevel.PRIVATE)
    private String totalShippingPrice;
    private Number subtotal_price;

    public Number getSubtotal_price() {
        if (subtotalPrice == null) {
            return null;
        }
        return Integer.valueOf(subtotalPrice);
    }

    @Getter(AccessLevel.PRIVATE)
    private String subtotalPrice;
    private List<String> tags;
    private TaxLineDTO[] tax_lines;

    public TaxLineDTO[] getTax_lines() {
        if (taxLines == null) {
            return null;
        }
        return getTaxLines();
    }

    @Getter(AccessLevel.PRIVATE)
    private TaxLineDTO[] taxLines;

    private Number tax_price;

    public Number getTax_price() {
        if (totalTax == null) {
            return null;
        }
        return Integer.valueOf(totalTax);
    }

    @Getter(AccessLevel.PRIVATE)
    private String totalTax;

    private Number total_discounts;
    @Getter(AccessLevel.PRIVATE)
    private String totalDiscounts;

    public Number getTotal_discounts() {
        if (totalDiscounts == null) {
            return null;
        }
        return Integer.valueOf(totalDiscounts);
    }

    private Integer total_net_amount;

    public Number getTotal_net_amount() {
        if (totalRefunded == null || totalPrice == null) {
            return null;
        }
        return getTotal_price() - getTotal_refunded_amount();
    }

    @Getter(AccessLevel.PRIVATE)
    private String totalPrice;
    private Integer total_price;

    public Integer getTotal_price() {
        if (totalPrice == null) {
            return null;
        }
        return Integer.valueOf(totalPrice);
    }

    @Getter(AccessLevel.PRIVATE)
    private String totalRefunded;
    private Number total_refunded_amount;

    public Integer getTotal_refunded_amount() {
        if (totalRefunded == null) {
            return null;
        }
        return Integer.valueOf(totalRefunded);
    }

    private TransactionDTO[] transactions;
}
