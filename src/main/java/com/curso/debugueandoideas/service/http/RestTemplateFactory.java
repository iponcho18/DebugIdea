package com.curso.debugueandoideas.service.http;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateFactory {

    public RestTemplate build(Integer timeoutSeconds) {
        int t = (timeoutSeconds == null || timeoutSeconds <= 0) ? 5 : timeoutSeconds;
        int timeoutMs = t * 1000;

        SimpleClientHttpRequestFactory rf = new SimpleClientHttpRequestFactory();
        rf.setConnectTimeout(timeoutMs);
        rf.setReadTimeout(timeoutMs);

        return new RestTemplate(rf);
    }
}