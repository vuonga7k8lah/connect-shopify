package com.wiloke.shopify.connection.dto.shopify.skeleton;

import com.wiloke.shopify.connection.dto.shopify.CollectionDataDTO;
import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
import com.wiloke.shopify.connection.repositories.skeleton.CommandSkeleton;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollectionSkeleton extends CommandSkeleton {
    private CollectionDataDTO data;
    private QueryCostDTO extensions;
    private String error;
}
