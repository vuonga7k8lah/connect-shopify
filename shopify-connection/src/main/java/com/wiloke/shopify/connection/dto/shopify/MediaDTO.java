package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MediaDTO {
    // Thực tế có hoặc không
    private Number aspect_ratio;
    private Number height;
    private String src;
    private Number width;

    // Theo docs nhưng thực tế có thể không có
    private Object media_type;

    // Theo docs
    private String alt;
    private String id;
    public String getId(){
        if (preview == null) {
            return null;
        }
        return preview.getImage().getId();
    }
    private Object position;

    public Object getPosition() {
        if (mediaContentType == null) {
            return null;
        }
        return mediaContentType;
    }

    private ImageDTO preview_image;

    public ImageDTO getPreview_image() {
        if (preview == null) {
            return null;
        }
        return preview.getImage();
    }

    @Getter(AccessLevel.PRIVATE)
    private PreviewImageDTO preview;
    @Getter(AccessLevel.PRIVATE)
    private String mediaContentType;
}
