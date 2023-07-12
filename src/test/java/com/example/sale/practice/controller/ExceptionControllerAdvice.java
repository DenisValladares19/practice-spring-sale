package com.example.sale.practice.controller;

import com.example.sale.practice.dto.ResponseDTO;
import com.example.sale.practice.exception.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ResponseDTO> handleRequestException(RequestException ex) {
        var response = ResponseDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (ex.getStatus() != null) {
            status = ex.getStatus();
        }

        return new ResponseEntity<ResponseDTO>(response, status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        var response = ResponseDTO.builder()
                .code("400")
                .message("invalid field")
                .content(errors)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
