package com.wiloke.corecommon.kafka;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrchestratorSectionVersionDTO {
    private OrchestratorChangelogDTO currentVersion;
    private List<OrchestratorChangelogDTO> changelog;
}
