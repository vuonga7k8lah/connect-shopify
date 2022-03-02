package com.wiloke.corecommon.kafka;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrchestratorChangelogDTO {
    private String version;
    private String content;
    private String versionId;
}
