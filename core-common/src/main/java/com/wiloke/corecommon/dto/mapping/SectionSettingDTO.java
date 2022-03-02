package com.wiloke.corecommon.dto.mapping;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SectionSettingDTO extends ChildType{
    private Boolean disable;
    private Boolean drawer;
    private String id;
    private Object label;
    private String name;
    private Boolean open;
    private String type;
//    private Number max;
//    private Number min;
    private Object children; // Children phu thuoc vao type
}
