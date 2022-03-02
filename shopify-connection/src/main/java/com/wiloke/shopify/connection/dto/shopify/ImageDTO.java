package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiloke.shopify.connection.utils.IdUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageDTO {
    @Setter(AccessLevel.PRIVATE)
    private String created_at;

    @Setter(AccessLevel.PRIVATE)
    private String updated_at;

    private Number aspect_ratio;
    private String id;

    @Setter(AccessLevel.PRIVATE)
    private String media_type = "image";

    @Setter(AccessLevel.PRIVATE)
    private String preview_image;
    private String product_id;
    private String src;
    private Integer width;
    private Integer height;

    @Getter(AccessLevel.PRIVATE)
    private String altText;

    private String url;
    private String originalSrc;

    @Getter(AccessLevel.PRIVATE)
    private MetafieldEdgesDTO metafields;

    public String alt;

    private Boolean attached_to_variant = false; // Có thể Null vì featured image k cần có
    private List<VariantsEdgesDTO> variants; // Có thể Null vì featured image k cần có
    private List<Number> variant_ids; // Có thể Null vì featured image k cần có
    private String position; // Có thể có hoặc không. position is returned only when the image is associated with a product.

    public Number getAspect_ratio() {
        return (float)width / height;
    }

    public String getId() {
        if (id == null) {
            return null;
        }
        return IdUtils.removeStringFromId(id);
    }

    public String getCreated_at() {
        return new Date().toString();
    }

    public String getUpdated_at() {

        return new Date().toString();
    }

    public String getAlt() {
        if (altText == null) {
            return null;
        }
        return this.altText;
    } // Có thể null

    public String getPreview_image() {
        if (url == null) {
            return null;
        }
        return this.url;
    }
}
