package com.curso.debugueandoideas.service;

import com.curso.debugueandoideas.dto.DtoService;
import com.curso.debugueandoideas.dto.common.ExternalCallResult;
import com.curso.debugueandoideas.dto.service.IfconfigAllResponse;
import com.curso.debugueandoideas.service.http.RestTemplateFactory;
import com.curso.debugueandoideas.service.http.ServiceEndpointResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class IfconfigService {

    private final ServiceService serviceService;
    private final ServiceEndpointResolver resolver;
    private final RestTemplateFactory restTemplateFactory;
    private final ObjectMapper objectMapper; // Jackson 2 en Boot 2.7

    public ExternalCallResult<IfconfigAllResponse> getAll() {

        DtoService cfg = serviceService.getService("IFCONFIG");

        log.info(cfg);
        // Ajusta estos nombres si tu DtoService usa minúsculas
        String baseUrl = resolver.buildBaseUrl(cfg, "ifconfig.io");
        String endpoint = resolver.normalizeEndpoint(cfg.getBaseurl(), "/all.json");
        String url = baseUrl + endpoint;

        log.info(url);
        RestTemplate rt = restTemplateFactory.build(cfg.getTimeout());

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.USER_AGENT, "debugueandoideas/1.0");

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> resp = rt.exchange(url,cfg.getMethod(), entity, String.class);
          log.info(resp);
            int status = resp.getStatusCodeValue();
            MediaType ct = resp.getHeaders().getContentType();
            String contentType = (ct != null ? ct.toString() : null);

            String raw = resp.getBody();
            log.debug("IFCONFIG status={} contentType={} raw={}", status, contentType, raw);

            // Si NO es 2xx, regresa result con error + raw
            if (!resp.getStatusCode().is2xxSuccessful()) {
                return ExternalCallResult.<IfconfigAllResponse>builder()
                        .statusCode(status)
                        .contentType(contentType)
                        .error("IFCONFIG respondió HTTP " + status)
                        .rawBody(raw)
                        .build();
            }

            // Si es 2xx, intenta parsear manualmente (independiente de content-type)
            IfconfigAllResponse dto = objectMapper.readValue(raw, IfconfigAllResponse.class);

            return ExternalCallResult.<IfconfigAllResponse>builder()
                    .statusCode(status)
                    .contentType(contentType)
                    .data(dto)
                    .rawBody(raw) // opcional, puedes quitarlo si no quieres exponerlo
                    .build();

        } catch (HttpStatusCodeException ex) {
            // Cuando RestTemplate lanza excepción por 4xx/5xx (a veces)
            int status = ex.getRawStatusCode();
            String raw = ex.getResponseBodyAsString(StandardCharsets.UTF_8);

            return ExternalCallResult.<IfconfigAllResponse>builder()
                    .statusCode(status)
                    .contentType(ex.getResponseHeaders() != null && ex.getResponseHeaders().getContentType() != null
                            ? ex.getResponseHeaders().getContentType().toString()
                            : null)
                    .error("HTTP error llamando IFCONFIG: " + ex.getMessage())
                    .rawBody(raw)
                    .build();

        } catch (ResourceAccessException ex) {
            // timeouts, DNS, conexión, etc.
            return ExternalCallResult.<IfconfigAllResponse>builder()
                    .statusCode(504)
                    .error("Timeout/Conectividad llamando IFCONFIG: " + ex.getMessage())
                    .build();

        } catch (Exception ex) {
            return ExternalCallResult.<IfconfigAllResponse>builder()
                    .statusCode(500)
                    .error("Error procesando IFCONFIG: " + ex.getMessage())
                    .build();
        }
    }
}
