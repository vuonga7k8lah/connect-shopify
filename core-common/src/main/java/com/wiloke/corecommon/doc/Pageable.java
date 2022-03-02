package com.wiloke.corecommon.doc;

import lombok.Data;

@Data
public class Pageable {
    public PageableSort sort = new PageableSort();
    private final int numberOfElements = 1;
    private final int number = 1;
    private final int size = 1;
    private final int totalPages = 1;
}
