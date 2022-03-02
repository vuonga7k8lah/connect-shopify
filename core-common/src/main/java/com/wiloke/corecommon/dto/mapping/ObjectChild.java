package com.wiloke.corecommon.dto.mapping;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ObjectChild extends ChildType {
    protected List<PrimitiveChild> children;
}
