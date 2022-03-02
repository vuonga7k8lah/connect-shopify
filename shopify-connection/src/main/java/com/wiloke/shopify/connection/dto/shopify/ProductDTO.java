package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiloke.shopify.connection.utils.IdUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private String id;
    private CollectionsDTO collections;

    public Object getCollections() {
        if (collections == null) {
            return null;
        }
        return Arrays.stream(collections.getEdges()).map(CollectionNodeDTO::getNode).collect(Collectors.toList());
    }

    private Boolean gift_card = true;//default data

    public String getId() {
        if (this.id == null) {
            return null;
        }
        return IdUtils.removeStringFromId(this.id);
    }

    public String getPrice() {
        if (priceRangeV2 == null) {
            return null;
        }
        return priceRangeV2.getMaxVariantPrice().getAmount();
    }

    private Number price;
    private String title;
    private String vendor;
    private String handle;
    private Boolean available = true;
    private Number compare_at_price;

    public Number getCompare_at_price() {
        if (variants == null) {
            return null;
        }
        if (variants.getEdges() == null) {
            return null;
        }
        return getCompare_at_price_max();
    }

    private Number compare_at_price_max;

    public Number getCompare_at_price_max() {
        if (variants == null) {
            return null;
        }
        if (variants.getEdges() == null) {
            return null;
        }
        var compareAtPrice = Arrays.stream(variants.getEdges()).
                filter(empty -> (empty.getNode().getCompare_at_price() != null)).
                map(variants -> Integer.valueOf(variants.getNode().getCompare_at_price()))
                .collect(Collectors.toList());

        var max = compareAtPrice.stream().max(Comparator.naturalOrder());
        return max.orElse(null);
    }

    private Number compare_at_price_min;

    public Number getCompare_at_price_min() {
        if (variants == null) {
            return null;
        }
        if (variants.getEdges() == null) {
            return null;
        }
        var compareAtPrice = Arrays.stream(variants.getEdges()).
                filter(empty -> (empty.getNode().getCompare_at_price() != null)).
                map(variants -> Integer.valueOf(variants.getNode().getCompare_at_price()))
                .collect(Collectors.toList());

        var min = compareAtPrice.stream().min(Comparator.naturalOrder());
        return min.orElse(null);
    }

    private Boolean compare_at_price_varies;

    public Boolean getCompare_at_price_varies() {
        if (getCompare_at_price_max() == null || getCompare_at_price_min() == null) {
            return null;
        }
        return !getCompare_at_price_min().equals(getCompare_at_price_max());
    }

    private String content;

    public String getContent() {
        if (bodyHtml == null) {
            return null;
        }
        return bodyHtml;
    }

    @Getter(AccessLevel.PRIVATE)
    private String bodyHtml;
    @Getter(AccessLevel.PRIVATE)
    private PriceRangV2DTO priceRangeV2;
    private String description;

    public String getDescription() {
        if (descriptionHtml == null) {
            return null;
        }
        return descriptionHtml;
    }

    @Getter(AccessLevel.PRIVATE)
    private String descriptionHtml;
    private ImageDTO featured_image;

    public ImageDTO getFeatured_image() {
        if (featuredImage == null) {
            return null;
        }
        return featuredImage;
    }

    @Getter(AccessLevel.PRIVATE)
    private ImageDTO featuredImage;
    private ImagesEdgesDTO images;

    public Object getImages() {
        if (images == null) {
            return null;
        }
        if (images.getEdges() == null) {
            return null;
        }
        return Arrays.stream(images.getEdges()).map(ImageNodeDTO::getNode).collect(Collectors.toList());
    }

    private MediaEdgesDTO media;

    public Object getMedia() {
        if (media == null) {
            return null;
        }
        if (media.getEdges() == null) {
            return null;
        }
        return Arrays.stream(media.getEdges()).map(MediaNodeDTO::getNode).collect(Collectors.toList());
    }

    private ProductOptionDTO[] options;
    private String price_max;

    public String getPrice_max() {
        if (priceRangeV2 == null) {
            return null;
        }
        return priceRangeV2.getMaxVariantPrice().getAmount();
    }

    private String price_min;

    public String getPrice_min() {
        if (priceRangeV2 == null) {
            return null;
        }
        return priceRangeV2.getMinVariantPrice().getAmount();
    }

    private Boolean price_varies;

    public Boolean getPrice_varies() {
        if (getPrice_max() == null || getPrice_min() == null) {
            return null;
        }
        return !getPrice_max().equals(getPrice_min());
    }

    private String published_at;

    public String getPublished_at() {
        if (publishedAt == null) {
            return null;
        }
        return publishedAt;
    }

    @Getter(AccessLevel.PRIVATE)
    private String publishedAt;

    private String created_at;

    public String getCreated_at() {
        if (createdAt == null) {
            return null;
        }
        return createdAt;
    }

    @Getter(AccessLevel.PRIVATE)
    private String createdAt;
    private String type;
    @Getter(AccessLevel.PRIVATE)
    private String productType;
    // variants: Partial<Variant>[];


    private List<String> tags;
    private ProductVariantsDTO variants;

    public Object getVariants() {
        if (variants == null) {
            return null;
        }
        if (variants.getEdges() == null) {
            return null;
        }
        return Arrays.stream(variants.getEdges()).map(VariantsEdgesDTO::getNode).collect(Collectors.toList());
    }

    public String getType() {
        if (productType == null) {
            return null;
        }
        return this.productType;
    }
}
