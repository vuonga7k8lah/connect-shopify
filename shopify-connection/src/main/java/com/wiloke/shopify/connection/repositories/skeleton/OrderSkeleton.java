package com.wiloke.shopify.connection.repositories.skeleton;

import com.wiloke.shopify.connection.dto.shopify.CustomersDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Repository;

@EqualsAndHashCode(callSuper = true)
@Repository
@Data
public class OrderSkeleton extends CommandSkeleton{
    private CustomersDTO data;
    private Object extensions;
}
