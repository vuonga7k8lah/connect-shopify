package com.wiloke.shopify.connection.dto.shopify;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class LocalizationFakeDTO {
    private String[] available_countries;

    public List<String> getAvailable_countries() {
        var data = new ArrayList<String>();
        data.add("Åland Islands");
        data.add("Albania");
        data.add("Algeria");
        data.add("Andorra");
        data.add("Angola");
        data.add("Anguilla");
        data.add("Antigua &amp; Barbuda");
        data.add("Argentina");
        data.add("Armenia");
        data.add("Aruba");
        data.add("Ascension Island");
        data.add("Australia");
        data.add("Canada");
        data.add("French Polynesia");
        data.add("Germany");
        data.add("New Caledonia");
        data.add("Vietnam");
        data.add("Wallis &amp; Futuna");
        return data;
    }

    public Object getAvailable_languages() {
        var data = new ArrayList<>();
        var dataShopLocale = new HashMap<String,Object>();
        dataShopLocale.put("shop_locale",new ShopLocaleFakeDTO());
        data.add(dataShopLocale);
        return data;
    }

    private String country = "Vietnam";

    public Object getLanguage() {
        var data = new HashMap<String,Object>();
        data.put("shop_locale",new ShopLocaleFakeDTO());
        return data;
    }
}
