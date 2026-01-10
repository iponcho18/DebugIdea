package com.curso.debugueandoideas.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex,
                                                     HttpServletRequest req) {

        List<ApiError.FieldViolation> violations = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::toViolation)
                .collect(Collectors.toList()); // ✅ Java 11

        ApiError apiError = ApiError.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST) // o HttpStatus.UNPROCESSABLE_ENTITY (422)
                .error("VALIDATION_ERROR")
                .message("Validation failed")
                .path(req.getRequestURI())
                .violations(violations)
                .build();

        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> notFound(NotFoundException ex, HttpServletRequest req) {
        ApiError apiError = ApiError.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND)
                .error("NOT_FOUND")
                .message(ex.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> exception(Exception ex, HttpServletRequest req) {
        ApiError apiError = ApiError.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST)
                .error("EXCEPTION")
                .message(ex.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    private ApiError.FieldViolation toViolation(FieldError fe) {
        return ApiError.FieldViolation.builder()
                .field(fe.getField())
                .message(fe.getDefaultMessage())
                .build();
    }
}
