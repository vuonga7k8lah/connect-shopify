package com.wiloke.shopify.connection.utils;

public enum CollectionSortBy {
    MANUAL {
        public String toString() {
            return "manual";
        }
    },

    BEST_SELLING{
        public String toString() {
            return "best-selling";
        }
    },

    TITLE_ASCENDING{
        public String toString() {
            return "title-ascending";
        }
    },

    TITLE_DESCENDING{
        public String toString() {
            return "title-descending";
        }
    },

    PRICING_ASCENDING{
        public String toString() {
            return "price-ascending";
        }
    },

    PRICE_DESCENDING{
        public String toString() {
            return "price-descending";
        }
    },

    CREATED_ASCENDING{
        public String toString() {
            return "created-ascending";
        }
    },

    CREATED_DESCENDING{
        public String toString() {
            return "created-descending";
        }
    },
}
