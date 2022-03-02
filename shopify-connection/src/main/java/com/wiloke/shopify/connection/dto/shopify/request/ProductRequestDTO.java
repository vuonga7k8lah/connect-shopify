package com.wiloke.shopify.connection.dto.shopify.request;

import com.wiloke.shopify.connection.dto.shopify.request.pluck.ProductPluck;
import com.wiloke.shopify.connection.dto.shopify.request.pluck.ShopInfoPluck;
import com.wiloke.shopify.connection.utils.IdUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductRequestDTO extends DTORequestable<ProductPluck>  {
    @Override
    public ProductPluck[] getAllPluck() {
        return  Arrays.stream(ProductPluck.values()).filter(pluck->pluck.getIsDefault().equals(true)).toArray(ProductPluck[]::new);
    }

}
