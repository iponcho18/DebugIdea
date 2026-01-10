package com.curso.debugueandoideas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoService {
    private String host;
    private Integer port;
    private Integer timeout;
    private Integer secure;   // 0/1 (si quieres, lo cambiamos a Boolean)
    private String baseurl;   // ej: "/all.json"
    private String name;      // nombre lógico del servicio, NO concatenar a la URL
    private HttpMethod method;
}
