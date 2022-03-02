package com.wiloke.shopify.connection.routes;

import com.wiloke.shopify.connection.dto.shopify.request.CollectionRequestDTO;
import com.wiloke.shopify.connection.services.ShopifyServiceAble;
import com.wiloke.shopify.connection.utils.APIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = APIUtil.COLLECTION_ENDPOINT)
@Component
public class CollectionController {
    @Autowired
    @Qualifier(value = "CollectionServiceImpl")
    private ShopifyServiceAble<CollectionRequestDTO> collectionService;

    @GetMapping
    public ResponseEntity<Object> getCollections(CollectionRequestDTO collectionRequestDTO) throws Exception {
        var x = this.collectionService.getData(collectionRequestDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(x);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getCollection(@PathVariable("id") String id, @Valid CollectionRequestDTO collectionRequestDTO) throws Exception {
        collectionRequestDTO.setId(id);
        var x = this.collectionService.getData(collectionRequestDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(x);
    }
}
