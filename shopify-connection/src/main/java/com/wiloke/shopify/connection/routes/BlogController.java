package com.wiloke.shopify.connection.routes;

import com.wiloke.shopify.connection.dto.shopify.request.BlogRequestDTO;
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
@RequestMapping(path = APIUtil.BLOG_ENDPOINT)
@Component
@Validated
public class BlogController {
    @Autowired
    @Qualifier(value = "BlogServiceImpl")
    private ShopifyServiceAble<BlogRequestDTO> orderService;

    @ResponseBody
    @GetMapping
    public ResponseEntity<Object> getBlogs(@Valid BlogRequestDTO blogRequestDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.orderService.getData(blogRequestDTO));
    }
}
