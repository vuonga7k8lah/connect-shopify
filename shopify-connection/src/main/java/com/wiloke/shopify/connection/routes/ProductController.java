package com.wiloke.shopify.connection.routes;

import com.wiloke.shopify.connection.dto.shopify.request.ProductRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.request.ShopRequestDTO;
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
import java.util.HashMap;

@RestController
@RequestMapping(path = APIUtil.PRODUCT_ENDPOINT)
@Component
@Validated
public class ProductController {
    @Autowired
    @Qualifier(value = "ProductServiceImpl")
    private ShopifyServiceAble<ProductRequestDTO> productService;


    @GetMapping
    @ResponseBody
    public ResponseEntity<Object> getProducts(@Valid ProductRequestDTO productQueryDTO) throws Exception {

        var productData=this.productService.getData(productQueryDTO);
        HashMap<String,Object> data = new HashMap<>();
        data.put("products",productData);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(data);
    }
}
