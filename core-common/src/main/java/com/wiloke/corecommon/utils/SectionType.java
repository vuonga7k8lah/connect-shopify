package com.wiloke.corecommon.utils;

import lombok.Getter;

@Getter
public enum SectionType {
    MEGAMENU("megamenu"),
    HEADER("header"),
    FOOTER("footer"),
    DEFAULT("default"); // của nhà cung cấp. Ví dụ: Wiloke Team

    private final String type;

    SectionType(String type) {
        this.type = type;
    }
}
