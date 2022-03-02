package com.wiloke.shopify.connection.dto.shopify.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortUtils {
    public static List<HashMap<String, String>> getSortByOptions() {
        List<HashMap<String,String>> list = new ArrayList<>();

        HashMap<String, String> mMap = new HashMap<>();
        mMap.put("name", "manual");
        mMap.put("value","Featured");
        list.add(mMap);

        HashMap<String, String> mMap1 = new HashMap<>();
        mMap1.put("name", "best-selling");
        mMap1.put("value","Best Selling");
        list.add(mMap1);

        HashMap<String, String> mMap2 = new HashMap<>();
        mMap2.put("name", "title-ascending");
        mMap2.put("value","Alphabetically, A-Z");
        list.add(mMap2);

        HashMap<String, String> mMap3 = new HashMap<>();
        mMap3.put("name", "title-descending");
        mMap3.put("value","Alphabetically, Z-A");
        list.add(mMap3);

        HashMap<String, String> mMap4 = new HashMap<>();
        mMap4.put("name", "price-ascending");
        mMap4.put("value","Price, low to high");
        list.add(mMap4);

        HashMap<String, String> mMap5 = new HashMap<>();
        mMap5.put("name", "price-descending");
        mMap5.put("value", "Price, high to low");
        list.add(mMap5);

        HashMap<String, String> mMap6 = new HashMap<>();
        mMap6.put("name", "created-ascending");
        mMap6.put("value", "Date, old to new");
        list.add(mMap6);

        HashMap<String, String> mMap7 = new HashMap<>();
        mMap7.put("name", "created-descending");
        mMap7.put("value", "Date, new to old");
        list.add(mMap7);

        return list;
    }
}
