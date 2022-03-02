package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiloke.shopify.connection.utils.TypeDiscountApplication;
import lombok.Data;

import java.util.ArrayList;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutFakeDTO {
    public Object getApplied_gift_cards() {
        var giftCardDTO = new GiftCardDTO();
        giftCardDTO.setBalance(100);
        giftCardDTO.setCurrency("USD");
        giftCardDTO.setCode("MYSHOPKIT");
        giftCardDTO.setEnabled(true);
        giftCardDTO.setExpired(true);
        giftCardDTO.setBalance(100);
        giftCardDTO.setLast_four_characters("PKIT");
        giftCardDTO.setInitial_value("50.00");
        return giftCardDTO;
    }

    private String attributes = "Haku";
    private Object billing_address;

    public CustomerAddressDTO getBilling_address() {
        var addressDTO = new CustomerAddressDTO();
        addressDTO.setAddress1("Chestnut Street 92");
        addressDTO.setId("550558813");
        addressDTO.setPhone("555-625-1199");
        addressDTO.setFirst_name("Bob");
        addressDTO.setLast_name("Norman");
        addressDTO.setCity("city");
        addressDTO.setProvince("Kentucky");
        addressDTO.setCountry_code("KY");
        addressDTO.setCountry("country");
        addressDTO.setCountry_code("US");
        addressDTO.setZip("40202");
        return addressDTO;
    }

    private Boolean buyer_accepts_marketing = false;

    public Object getCart_level_discount_applications() {
        var data = new ArrayList<>();
        data.add(getDiscount_applications());
        data.add(getDiscount_applications());
        return data;
    }

    private String currency = "USD";

    public Object getCustomer() {

        var customerDTO = new CustomerDTO();
        customerDTO.setEmail("bob.norman@hostmail.com");
        customerDTO.setId("207119551");
        customerDTO.setAcceptsMarketing(false);
        customerDTO.setFirstName("Bob");
        customerDTO.setLastName("Norman");
        customerDTO.setOrders_count(1);
        customerDTO.setTotalSpent("199.65");
        customerDTO.setPhone("+16136120707");
        customerDTO.setDefaultAddress(getBilling_address());
        return customerDTO;
    }

    public Object getDiscount_applications() {
        var data = new DiscountApplicationDTO();
        data.setTitle("SUMMER16");
        data.setType(TypeDiscountApplication.DISCOUNT_CODE);
        data.setTotal_allocated_amount(20);
        data.setValue("SUMMER16");
        return data;
    }

    private Number discounts_amount = 22;
    private Number discounts_savings = 22;
    private String email = "bob.norman@hostmail.com";
    private Number gift_cards_amount = 22;
    private Number id = 450789469;

    public Object getLine_items() {
        var imageDTO = new ImageDTO();
        imageDTO.setAltText("IPod Nano - 8GB");
        imageDTO.setWidth(300);
        imageDTO.setHeight(168);
        imageDTO.setAltText("IPod Nano - 8GB");
        imageDTO.setUrl("https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano-2.png?v=1643923962");

        var lineItems = new LineItemDTO();
        lineItems.setId("b721507a3fc9adfd");
        lineItems.setKey("b721507a3fc9adfd");
        lineItems.setSku("IPOD2008RED");
        lineItems.setVendor("vendor");
        lineItems.setTitle("IPod Nano - 8GB");
        lineItems.setGrams(200);
        lineItems.setFinal_line_price(199);
        lineItems.setQuantity(1);
        lineItems.setFulfillment_service("manual");
        lineItems.setImage(imageDTO);
        var data = new ArrayList<>();
        data.add(lineItems);
        data.add(lineItems);
        return data;
    }

    private Number line_items_subtotal_price = 2;
    private String name = "#901414060";
    private String note = "";
    private Object order;
    private String order_id = "450789469";
    private String order_name;
    private Number order_number = 2;
    private Boolean requires_shipping = true;

    public Object getShipping_address() {
        return getBilling_address();
    }

    public Object getShipping_method() {
        var shipping = new ShippingMethodDTO();
        shipping.setHandle("shopify-international-shipping-25.00");
        shipping.setTitle("International Shipping");
        shipping.setPrice(15);
        shipping.setOriginal_price(20);
        return shipping;
    }

    public Object getShipping_methods() {
        var listShipping = new ArrayList<>();
        listShipping.add(getShipping_method());
        listShipping.add(getShipping_method());
        return listShipping;
    }

    private Number shipping_price = 0.00;
    private String[] tax_lines;
    private Number tax_price = 398.00;
    private Number total_price = 0.00;

    public Object getTransactions() {
        var transactionsDTO = new TransactionDTO();
        transactionsDTO.setAmount(209.00);
        transactionsDTO.setCreatedAt("2005-08-05T12:59:12-04:00");
        transactionsDTO.setGateway("bogus");
        transactionsDTO.setKind("refund");
        transactionsDTO.setStatus("success");
        var formatData = new ArrayList<>();
        formatData.add(transactionsDTO);
        return formatData;
    }

}
