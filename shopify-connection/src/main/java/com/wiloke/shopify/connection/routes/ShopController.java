package com.wiloke.shopify.connection.routes;

import com.wiloke.shopify.connection.dto.shopify.request.ShopRequestDTO;
import com.wiloke.shopify.connection.services.ShopifyServiceAble;
import com.wiloke.shopify.connection.utils.APIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path = APIUtil.SHOP_INFO_ENDPOINT)
@Component
@Validated
public class ShopController {
    @Autowired
    @Qualifier(value = "ShopServiceImpl")
    private ShopifyServiceAble<ShopRequestDTO> shopService;


    @GetMapping
    @ResponseBody
    public ResponseEntity<Object> getShopInfo(@Valid ShopRequestDTO shopQueryDTO) throws Exception {
        var x = this.shopService.getData(shopQueryDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(x);
    }
}
