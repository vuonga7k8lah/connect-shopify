package com.wiloke.corecommon.dto;

import lombok.Data;

@Data
public class PrivateShopWrapResponseDTO {
    private PrivateShopResponseDTO data;

    /**
     * Message or decrible abount data content.
     */
    private String message;

    /**
     * Status of data content
     */
    private int code;
}
