package com.curso.debugueandoideas.dto.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExternalCallResult<T> {
    private int statusCode;
    private String contentType;

    /** data solo viene cuando statusCode es 2xx y se pudo parsear */
    private T data;

    /** error/resumen si algo falló */
    private String error;

    /** body crudo para depurar (por ejemplo cuando viene HTML) */
    private String rawBody;

    public boolean is2xx() {
        return statusCode >= 200 && statusCode < 300;
    }
}