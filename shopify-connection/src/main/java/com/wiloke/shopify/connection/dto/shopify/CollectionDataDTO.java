package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollectionDataDTO {
    private CollectionDTO collection;
    private CollectionsDTO collections;
    public Object getCollections(){
        if (collections==null){
            return null;
        }
        if (collections.getEdges()==null){
            return null;
        }
        return Arrays.stream(collections.getEdges()).map(CollectionNodeDTO::getNode).collect(Collectors.toList());
    }
}
