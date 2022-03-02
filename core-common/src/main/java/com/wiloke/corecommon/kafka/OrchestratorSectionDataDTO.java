package com.wiloke.corecommon.kafka;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrchestratorSectionDataDTO {
    private String js;
    private String liquid;
    private Object schema;
    private String scss;
    private Object settings;
}
