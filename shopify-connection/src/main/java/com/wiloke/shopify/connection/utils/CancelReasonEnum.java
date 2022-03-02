package com.wiloke.shopify.connection.utils;

public enum CancelReasonEnum {
    ITEMS_UNAVAILABLE(), FRAUDULENT_ORDER, CUSTOMER_CHANGED, OTHER;

    public String getCancelReasonEnum() {
        switch (this) {
            case OTHER:
                return "other";
            case ITEMS_UNAVAILABLE:
                return "items unavailable";
            case FRAUDULENT_ORDER:
                return "fraudulent order";
            case CUSTOMER_CHANGED:
                return "customer changed/cancelled order";
            default:
                return null;
        }
    }
}
