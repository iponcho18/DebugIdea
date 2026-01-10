package com.curso.debugueandoideas.dto.service;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class IfconfigAllResponse {

    private String countryCode;
    private String encoding;
    private String forwarded;
    private String host;
    private String ifconfigCmdHostname;
    private String ifconfigHostname;
    private String ip;
    private String lang;
    private String method;
    private String mime;
    private Integer port;
    private String referer;
    private String ua;
}
