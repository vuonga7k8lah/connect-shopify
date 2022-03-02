package com.wiloke.shopify.connection.routes;

import com.wiloke.shopify.connection.dto.shopify.request.OrderRequestDTO;
import com.wiloke.shopify.connection.services.ShopifyServiceAble;
import com.wiloke.shopify.connection.utils.APIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = APIUtil.ORDER_ENDPOINT)
@Component
@Validated
public class OrderController {

    @Autowired
    @Qualifier(value = "OrderServiceImpl")
    private ShopifyServiceAble<OrderRequestDTO> orderService;


    @GetMapping
    @ResponseBody
    public ResponseEntity<Object> getOrders(@Valid OrderRequestDTO orderRequestDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.orderService.getData(orderRequestDTO));
    }
}
