package com.wiloke.shopify.connection.repositories.skeleton;

import com.wiloke.shopify.connection.dto.shopify.BlogDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Repository;

@EqualsAndHashCode(callSuper = true)
@Repository
@Data
public class BlogSkeleton extends CommandSkeleton {
    private BlogDTO[] blogs;
}
