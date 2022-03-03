package com.wiloke.shopify.connection.repositories.skeleton;

import com.wiloke.shopify.connection.dto.shopify.LocalizationFakeDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LocalizationSkeleton {
    public Object getData(){
        return new LocalizationFakeDTO();
    }

}
