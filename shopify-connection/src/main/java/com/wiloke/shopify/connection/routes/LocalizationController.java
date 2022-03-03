package com.wiloke.shopify.connection.routes;

import com.wiloke.shopify.connection.services.impl.CommentServiceImpl;
import com.wiloke.shopify.connection.services.impl.LocalizationServiceImpl;
import com.wiloke.shopify.connection.utils.APIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = APIUtil.LOCALIZATION_ENDPOINT)
@Component
public class LocalizationController {
    @Autowired
    private LocalizationServiceImpl localizationService;
    @RequestMapping
    public ResponseEntity<Object> getLocalization() throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(localizationService.getData());
    }
}
