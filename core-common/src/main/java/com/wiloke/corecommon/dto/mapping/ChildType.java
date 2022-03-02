package com.wiloke.corecommon.dto.mapping;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class  ChildType{
    protected Boolean disable;
    protected Boolean drawer;
    protected String id;
    protected Object label;
    protected String name;
    protected Boolean open;
    protected String type;
    protected List<Object> options;
    protected Object children; // Children phu thuoc vao type
}
