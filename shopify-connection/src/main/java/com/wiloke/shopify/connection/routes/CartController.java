package com.wiloke.shopify.connection.routes;

import com.wiloke.shopify.connection.services.impl.CartServiceImpl;
import com.wiloke.shopify.connection.utils.APIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = APIUtil.CART_ENDPOINT)
@Component
public class CartController {
    @Autowired
    private CartServiceImpl cartService;
    @RequestMapping
    public ResponseEntity<Object> getCart() throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cartService.getData());
    }
}
