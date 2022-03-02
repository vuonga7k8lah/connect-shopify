package com.wiloke.shopify.connection.dto.shopify;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DomainDTO {
    private String id;
    private String host;
    private LocalizationDTO localization;
    private String url;
    private Boolean sslEnabled;
}
