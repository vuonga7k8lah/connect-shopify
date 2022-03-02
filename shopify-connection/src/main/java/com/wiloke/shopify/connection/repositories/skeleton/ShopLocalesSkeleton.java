package com.wiloke.shopify.connection.repositories.skeleton;

import com.wiloke.shopify.connection.dto.shopify.ShopLocaleDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Repository;

@EqualsAndHashCode(callSuper = true)
@Repository
@Data
public class ShopLocalesSkeleton extends CommandSkeleton {
    private ShopLocaleDTO data;
}
