package com.wiloke.corecommon.kafka;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageCommandPackageToSectionCommandServiceDTO {
    private String pageCommandId;
    private String label;
    private String handle;
    private Long userId;
    private Object pageSettings;
    private List<?> files;
    private String type;
    private Boolean enable;
    private String scope;
    private List<OrchestratorSectionDTO> sections;
}
