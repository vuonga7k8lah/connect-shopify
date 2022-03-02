package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiloke.shopify.connection.utils.IdUtils;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopInfoDTO {
    private BillingAddressDTO address;

    public Object getAddress() {
        if (billingAddress == null) {
            return null;
        }
        return billingAddress;
    }

    private String name;
    private DomainDTO[] domains;
    private DomainDTO primaryDomain;
    private String email;
    private String id;

    public String getId() {
        if (id == null) {
            return null;
        }
        return IdUtils.removeStringFromId(id);
    }

    private String myshopifyDomain;
    private String contactEmail;
    private String description;
    private Integer collections_count = 4;
    private Object currency;

    public Object getCurrency() {
        if (currencySettings == null) {
            return null;
        }

        if (currencySettings.getEdges() == null) {
            return null;
        }
        return this.currencySettings.getEdges().stream().map(CurrencySettingsEdgesDTO::getNode).collect(Collectors.toList());
    }

    @Getter(AccessLevel.PRIVATE)
    private CurrencySettingsDTO currencySettings;

    private Boolean customer_accounts_enabled = false;
    private Boolean customer_accounts_optional = false;
    private String domain;
    private Boolean enabled_currencies = true;
    //    private Object enabled_payment_types;
    private MetafieldsEdges metafields;

    public Object getMetafields() {
        if (metafields == null) {
            return null;
        }
        return Arrays.stream(metafields.getEdges()).map(MetafieldsNode::getNode).collect(Collectors.toList());
    }

    @Setter(AccessLevel.PRIVATE)
    private String money_format;

    public String getMoney_format() {
        if (this.getCurrencyFormats() == null) {
            return null;
        }
        return this.getCurrencyFormats().getMoneyFormat();
    }

    @Getter(AccessLevel.PRIVATE)
    private CurrencyFormatsDTO currencyFormats;
    private String money_with_currency_format;

    public String getMoney_with_currency_format() {
        if (currencyFormats == null) {
            return null;
        }
        return currencyFormats.getMoneyWithCurrencyFormat();
    }

    private String password_message;
    @Setter(AccessLevel.PRIVATE)
    private String permanent_domain;

    public String getPermanent_domain() {
        if (myshopifyDomain == null) {
            return null;
        }
        return myshopifyDomain;
    }

    @Getter(AccessLevel.PRIVATE)
    private BillingAddressDTO billingAddress;
    private String phone;

    public String getPhone() {
        if (billingAddress == null) {
            return null;
        }
        return billingAddress.getPhone();
    }

    //private PolicyDTO[] policies;
//    private PolicyDTO privacy_policy;
//    private Object published_locales;
//    private PolicyDTO refund_policy;
//    private PolicyDTO shipping_policy;
//    private PolicyDTO subscription_policy;
 //   private String terms_of_service = "Privacy policy";//fake data
    private Integer products_count;
    private String secure_url;

    public String getSecure_url() {
        if (getUrl() == null) {
            return null;
        }
        return getUrl();
    }

    private String[] types;

    public List<String> getTypes() {
        if (productTypes == null) {
            return null;
        }
        if (productTypes.getEdges() == null) {
            return null;
        }
        return productTypes.getEdges().stream().map(ProductTypesEdgesDTO::getNode).collect(Collectors.toList());
    }

    @Getter(AccessLevel.PRIVATE)
    private ProductTypesDTO productTypes;
    private String url;
    private String[] vendors;

    public List<String> getVendors() {
        if (productVendors == null) {
            return null;
        }
        if (productVendors.getEdges() == null) {
            return null;
        }
        return productVendors.getEdges().stream().map(ProductTypesEdgesDTO::getNode).collect(Collectors.toList());
    }

    @Getter(AccessLevel.PRIVATE)
    private ProductTypesDTO productVendors;
}
