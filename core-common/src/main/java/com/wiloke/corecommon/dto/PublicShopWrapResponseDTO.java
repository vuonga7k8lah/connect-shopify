package com.wiloke.corecommon.dto;

import lombok.Data;

@Data
public class PublicShopWrapResponseDTO {
    private PublicShopDTO data;

    /**
     * Message or decrible abount data content.
     */
    private String message;

    /**
     * Status of data content
     */
    private int code;
}
