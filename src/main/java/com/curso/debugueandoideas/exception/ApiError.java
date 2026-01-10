package com.curso.debugueandoideas.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    @CreatedDate
    private Instant timestamp;
    private HttpStatus status;
    private String error;
    private String message;
    private String path;
    private List<FieldViolation> violations;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    @Log4j2
    public static class FieldViolation {
        private String field;
        private String message;
    }

}
