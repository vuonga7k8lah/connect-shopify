package com.wiloke.corecommon.kafka;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiloke.corecommon.utils.ItemScope;
import com.wiloke.corecommon.utils.SectionType;
import com.wiloke.corecommon.utils.TranslationUtil;
import com.wiloke.corecommon.validations.EnumValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrchestratorSectionDTO {
    private String id; // id của frontend

    private Long commandId; // id của frontend

    @NotBlank(message = "Please enter a label for this section")
    private String label;

    private String slug;

    private String megaMenuId;

    private List<String> addonIds;

    private String image;

    private String versionId; // chính là section id

    private String version;

    @NotBlank(message = "The content is required.")
    private OrchestratorSectionDataDTO data;

    @EnumValidator(enumClazz = ItemScope.class, message = TranslationUtil.invalidScope)
    private String scope = String.valueOf(ItemScope.PUBLISH.getScope());

    @EnumValidator(enumClazz = SectionType.class, message = TranslationUtil.invalidSectionType)
    private String type = String.valueOf(SectionType.DEFAULT.getType());

    private Boolean enable = true;

    //    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long userId;
}
