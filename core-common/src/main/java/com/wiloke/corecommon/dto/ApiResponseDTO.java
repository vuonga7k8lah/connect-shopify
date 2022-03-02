package com.wiloke.corecommon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseDTO<T,M> {

    private T info;

    /**
     * Message or decrible abount data content.
     */
    private M message;

    /**
     * Status of data content
     */
    private int code;

    /**
     * Status decrible
     */
    private String type;

}
