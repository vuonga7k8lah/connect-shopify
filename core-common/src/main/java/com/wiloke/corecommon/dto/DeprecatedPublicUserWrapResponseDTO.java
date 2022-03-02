package com.wiloke.corecommon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeprecatedPublicUserWrapResponseDTO {
    private DeprecatedPublicUserDTO data;

    /**
     * Message or decrible abount data content.
     */
    private String message;

    /**
     * Status of data content
     */
    private int code;
}
