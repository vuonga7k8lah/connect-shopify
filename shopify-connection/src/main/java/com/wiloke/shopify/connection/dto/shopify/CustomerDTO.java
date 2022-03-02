package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiloke.shopify.connection.utils.IdUtils;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {
    private Boolean accepts_marketing;

    public Boolean getAccepts_marketing() {
        if (acceptsMarketing == null) {
            return null;
        }
        return getAcceptsMarketing();
    }

    @Getter(AccessLevel.PRIVATE)
    private Boolean acceptsMarketing;
    private CustomerAddressDTO[] addresses;
    private Integer addresses_count;
    private CustomerAddressDTO default_address;

    public CustomerAddressDTO getDefault_address() {
        if (defaultAddress == null) {
            return null;
        }
        return getDefaultAddress();
    }

    @Getter(AccessLevel.PRIVATE)
    private CustomerAddressDTO defaultAddress;
    private String email;
    private String first_name;

    public String getFirst_name() {
        if (firstName == null) {
            return null;
        }
        return firstName;
    }

    @Getter(AccessLevel.PRIVATE)
    private String firstName;
    private Boolean has_account;
    private String id;

    public String getId() {
        if (id == null) {
            return null;
        }
        return IdUtils.removeStringFromId(this.id);
    }

    @Getter(AccessLevel.PRIVATE)
    private String lastName;
    private String last_name;

    public String getLast_name() {
        if (lastName == null) {
            return null;
        }
        return lastName;
    }

    private OrderDTO last_order;

    public OrderDTO getLast_order() {
        if (lastOrder == null) {
            return null;
        }
        return getLastOrder();
    }

    @Getter(AccessLevel.PRIVATE)
    private OrderDTO lastOrder;
    private String name;
    private OrdersDTO orders;

    public Object getOrders() {
        if (orders == null) {
            return null;
        }
        return Arrays.stream(orders.getEdges()).map(OrderNodeDTO::getNode).collect(Collectors.toList());
    }

    private Number orders_count;

    public Number getOrders_count() {
        if (orders == null) {
            return null;
        }
        return Arrays.stream(orders.getEdges()).count();
    }

    private String phone;
    private List<String> tags;
    private Boolean tax_exempt;

    public Boolean getTax_exempt() {
        if (taxExempt == null) {
            return null;
        }
        return taxExempt;
    }

    @Getter(AccessLevel.PRIVATE)
    private Boolean taxExempt;
    private String total_spent;

    public String getTotal_spent() {
        if (totalSpent == null) {
            return null;
        }
        return totalSpent;
    }

    @Getter(AccessLevel.PRIVATE)
    private String totalSpent;
}
