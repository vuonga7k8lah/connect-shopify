package com.wiloke.shopify.connection.routes;

import com.wiloke.shopify.connection.dto.shopify.request.ArticleRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.request.BlogRequestDTO;
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
import java.util.HashMap;

@RestController
@RequestMapping(path = APIUtil.ARTICLE_ENDPOINT)
@Component
@Validated
public class ArticleController {
    @Autowired
    @Qualifier(value = "ArticleServiceImpl")
    private ShopifyServiceAble<ArticleRequestDTO> articleService;


    @GetMapping(path = "{id}")
    @ResponseBody
    public ResponseEntity<Object> getArticles(@PathVariable("id") String id, @Valid ArticleRequestDTO articleRequestDTO) throws Exception {
        articleRequestDTO.setId(id);
        HashMap<String, Object> articleData = new HashMap<>();
        articleData.put("articles", this.articleService.getData(articleRequestDTO));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(articleData);
    }
}
