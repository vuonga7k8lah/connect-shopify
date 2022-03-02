package com.wiloke.shopify.connection.dto.shopify;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wiloke.shopify.connection.dto.shopify.utils.SortUtils;
import com.wiloke.shopify.connection.utils.IdUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollectionDTO {

    private String handle;
    private String id;

    public String getId() {
        if (this.id == null) {
            return null;
        }
        return IdUtils.removeStringFromId(this.id);
    }

    private String description;

    @Getter(AccessLevel.PRIVATE)
    private Number productsCount;

    @Getter(AccessLevel.PRIVATE)
    private CollectionRuleSetDTO ruleSet;

    private Number all_products_count;

    public Number getAll_products_count(){
        if (productsCount==null){
            return null;
        }
        return productsCount;
    }

    @Setter(AccessLevel.PRIVATE)
    private Set<String> all_types;

    @Setter(AccessLevel.PRIVATE)
    private Set<String> all_tags;

    @Setter(AccessLevel.PRIVATE)
    private Set<String> all_vendors;

   // @Getter(AccessLevel.PRIVATE)
    private CollectionProductsDTO products;

    private String cursor;

    private String default_sort_by = "best-selling";
    private String sort_by = "best-selling";
    private List<HashMap<String, String>> sort_options;

    public List<HashMap<String, String>> getSort_options() {
        return SortUtils.getSortByOptions();
    }

    private ImageDTO image;

    @Getter(AccessLevel.PRIVATE)
    private String updatedAt;

    @Getter(AccessLevel.PRIVATE)
    private String templateSuffix;

    @Setter(AccessLevel.PRIVATE)
    private String template_suffix;

    public String getTemplate_suffix() {
        return this.templateSuffix;
    }

    @Getter(AccessLevel.PRIVATE)
    private String descriptionHtml;
    @Setter(AccessLevel.PRIVATE)
    private String body_html;

    public String getBody_html() {
        return this.descriptionHtml;
    }

    public String getUpdated_at() {
        return this.updatedAt;
    }

    public String getPublished_at() {
        return this.updatedAt;
    }

//    @Getter(AccessLevel.PRIVATE)
//    private CollectionNodeDTO node;

    public Object getProducts() {
        if (this.products == null) {
            return null;
        }

        if (this.products.getEdges() == null) {
            return null;
        }

        return this.products.getEdges().stream().map(CollectionProductNodeDTO::getNode).collect(Collectors.toList());
    }

    public Set<String> getAll_types() {

        if (this.all_types != null){
            return this.all_types;
        }

        if (this.products == null) {
            return null;
        }

        if (this.products.getEdges() == null) {
            return null;
        }

        return this.all_types = this.products
                .getEdges()
                .stream()
                .filter(productEdges -> (productEdges.getNode().getType() != null)&&!Objects.equals(productEdges.getNode().getType(), ""))
                .map(products -> products.getNode().getType())
                .collect(Collectors.toSet());
    }
    public String getCurrent_type() {
        if (all_types != null && !all_types.isEmpty()){
            return all_types.stream().findFirst().get();
        }
        if (getAll_types()==null || getAll_types().isEmpty()){
            return null;
        }

        return getAll_types().stream().findFirst().get();
    }
    public String getCurrent_vendor() {
        if (all_vendors != null && !all_vendors.isEmpty()){
            return all_vendors.stream().findFirst().get();
        }
        if (getAll_vendors()==null || getAll_vendors().isEmpty()){
            return null;
        }

        return getAll_vendors().stream().findFirst().get();
    }
    public Set<String> getAll_vendors() {

        if (this.products == null) {
            return null;
        }

        if (this.products.getEdges() == null) {
            return null;
        }

        return this.products
                .getEdges()
                .stream()
                .filter(productEdges -> productEdges.getNode().getVendor() != null)
                .map(products -> products.getNode().getVendor())
                .collect(Collectors.toSet());
    }
    public Set<String> getAll_tags() {

        if (this.ruleSet != null && this.ruleSet.getRules() != null) {
            CollectionAllTagsDTO collectionAllTagsDTO = new CollectionAllTagsDTO();
            collectionAllTagsDTO.setTags(this.ruleSet.getRules());
            this.all_tags = collectionAllTagsDTO.getTags();
            return this.all_tags;
        }

        return null;
    }
    public ImageDTO getFeatured_image(){
        if (image==null){
            return null;
        }
        return image;
    };
    public ProductDTO getNext_product() {
        if (this.products != null) {
            if (this.products.getPageInfo() != null) {
                if (this.products.getPageInfo().isHasNextPage()) {
                    return new ProductDTO();
                }
            }
        }

        return null;
    }
    public String getUrl() {
        if (this.handle == null) {
            return null;
        }

        return "/collections/all/" + this.handle;
    }
    public ProductDTO getPrev_product() {
        if (this.products != null) {
            if (this.products.getPageInfo() != null) {
                if (this.products.getPageInfo().isHasPreviousPage()) {
                    return new ProductDTO();
                }
            }
        }

        return null;
    }
    private String title;
    @Getter(AccessLevel.PRIVATE)
    private String altText;
    public String getAlt(){
        if (altText==null){
            return null;
        }
        return altText;
    }
}
