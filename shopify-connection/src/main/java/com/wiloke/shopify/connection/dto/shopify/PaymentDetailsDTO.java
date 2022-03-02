package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

@Data
public class PaymentDetailsDTO {
    private String  credit_card_company;
    private String credit_card_number;
    private GiftCardDTO gift_card;
}
