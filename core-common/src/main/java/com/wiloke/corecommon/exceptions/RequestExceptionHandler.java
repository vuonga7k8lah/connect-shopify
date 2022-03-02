package com.wiloke.corecommon.exceptions;

public class RequestExceptionHandler extends RuntimeException {
    public RequestExceptionHandler(String message) {
        super(message);
    }

    public RequestExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }
}
