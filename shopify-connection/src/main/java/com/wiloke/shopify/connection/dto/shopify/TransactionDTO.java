package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiloke.shopify.connection.utils.IdUtils;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDTO {
    private Number amount;
    private String created_at;

    public String getCreated_at() {
        if (createdAt == null) {
            return null;
        }
        return getCreatedAt();
    }

    @Getter(AccessLevel.PRIVATE)
    private String createdAt;
    private String gateway;
    private String gateway_display_name;

    public String getGateway_display_name() {
        if (formattedGateway == null) {
            return null;
        }
        return formattedGateway;
    }

    @Getter(AccessLevel.PRIVATE)
    private String formattedGateway;
    private String id;

    public String getId() {
        if (id == null) {
            return null;
        }
        return IdUtils.removeStringFromId(id);
    }

    private String kind;
    private String name;
    private PaymentDetailsDTO payment_details;
    private String receipt;
    private String status;
    private String status_label;
    public String getStatus_label(){
        if (status==null){
            return null;
        }
        return status;
    }
}
