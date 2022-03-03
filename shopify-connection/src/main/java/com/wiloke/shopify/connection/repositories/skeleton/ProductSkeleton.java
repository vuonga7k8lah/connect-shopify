package com.wiloke.shopify.connection.repositories.skeleton;

import com.wiloke.shopify.connection.dto.shopify.ProductsDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Repository;

@EqualsAndHashCode(callSuper = true)
@Repository
@Data
public class ProductSkeleton extends CommandSkeleton{
    private ProductsDTO data;
    private Object extensions;
}
