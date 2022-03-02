package com.wiloke.corecommon.dto.mapping;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SectionWrapperDTO {
    private String js;
    private String liquid;
    private Object schema;
    private String scss;
    private List<SectionSettingDTO> settings;
}
