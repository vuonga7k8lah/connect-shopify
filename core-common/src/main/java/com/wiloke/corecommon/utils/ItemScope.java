package com.wiloke.corecommon.utils;

import lombok.Getter;

@Getter
public enum ItemScope {
    PUBLISH("publish"),
    PRIVATE("private");

    private final String scope;

    ItemScope(String scope) {
        this.scope = scope;
    }
}
