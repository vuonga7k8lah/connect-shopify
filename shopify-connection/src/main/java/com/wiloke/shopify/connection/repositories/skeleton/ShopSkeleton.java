package com.wiloke.shopify.connection.repositories.skeleton;

import com.wiloke.shopify.connection.dto.shopify.ShopDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Repository;

@EqualsAndHashCode(callSuper = true)
@Repository
@Data
public class ShopSkeleton extends CommandSkeleton{
    private ShopDTO data;
    private Object extensions;
}
