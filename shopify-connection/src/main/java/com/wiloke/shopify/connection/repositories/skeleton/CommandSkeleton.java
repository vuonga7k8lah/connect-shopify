package com.wiloke.shopify.connection.repositories.skeleton;

import com.wiloke.shopify.connection.dto.shopify.CheckoutFakeDTO;
import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;
import com.wiloke.shopify.connection.dto.shopify.request.CommentFakeDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CommandSkeleton {
    public Object getComments(){
        return (new CommentFakeDTO());
    }
}
