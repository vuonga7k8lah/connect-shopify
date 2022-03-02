package com.wiloke.corecommon.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserWrapResponseDTO {

    private UserResponseDTO info;

    /**
     * Message or decrible abount data content.
     */
    private String message;

    /**
     * Status of data content
     */
    private int code;

}