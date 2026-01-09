package com.curso.debugueandoideas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@Log
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private Instant timestamp = Instant.now();
    private int status;
    private String error;
    private String message;
    private String path;
    private List<FieldViolation> violations;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    @Log
    public static class FieldViolation {
        private String field;
        private String message;
    }

}
