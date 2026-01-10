package com.curso.debugueandoideas.service.http;

import com.curso.debugueandoideas.dto.DtoService;
import org.springframework.stereotype.Component;

@Component
public class ServiceEndpointResolver {

    public String buildBaseUrl(DtoService cfg, String defaultHost) {
        String host = (cfg == null || cfg.getHost() == null || cfg.getHost().isBlank())
                ? defaultHost
                : cfg.getHost().trim();

        boolean https = cfg != null && cfg.getSecure() != null && cfg.getSecure() == 1;
        String scheme = https ? "https" : "http";

        Integer port = (cfg != null) ? cfg.getPort() : null;

        if (port == null || port <= 0 || (https && port == 443) || (!https && port == 80)) {
            return scheme + "://" + host;
        }
        return scheme + "://" + host + ":" + port;
    }

    public String normalizeEndpoint(String baseurl, String defaultPath) {
        String p = (baseurl == null || baseurl.isBlank()) ? defaultPath : baseurl.trim();
        if (!p.startsWith("/")) p = "/" + p;
        return p;
    }
}
