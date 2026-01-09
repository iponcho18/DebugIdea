package com.curso.debugueandoideas.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> notFound(NotFoundException ex, HttpServletRequest req){
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).error("NOT FOUND").message(ex.getMessage()).build();
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> exception(Exception ex, HttpServletRequest req){
        ApiError apiError = ApiError.builder().status(HttpStatus.BAD_REQUEST).error("EXCEPTION").message(ex.getMessage()).build();
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }
}
