package com.wiloke.corecommon.kafka;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

// Sử dụng để bắn thông tin về 1 section của page được update
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectionCommandRequestPageCommandDTO {
    private String pageCommandId;
    private OrchestratorSectionDTO section;
}
