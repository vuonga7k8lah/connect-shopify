package com.wiloke.corecommon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
final public class ApiErrorResponseDTO<T> {

    /**
     * Message or decrible abount data content.
     */
    private T message;

    /**
     * Status of data content
     */
    private int code;

    /**
     * Status decrible
     */
    private String type;

    public ApiErrorResponseDTO(T message, int status, String type){
        setMessage(message);
        setCode(status);
        setType(type);
    }
}
