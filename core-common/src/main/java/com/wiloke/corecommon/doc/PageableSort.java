package com.wiloke.corecommon.doc;

import lombok.Data;

@Data
public class PageableSort {
    private boolean shorted = false;
    private boolean unsorted = false;
    private boolean empty = false;
}
