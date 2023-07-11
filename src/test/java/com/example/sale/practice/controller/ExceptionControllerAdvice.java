package com.example.sale.practice.controller;

import com.example.sale.practice.dto.ResponseDTO;
import com.example.sale.practice.exception.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
