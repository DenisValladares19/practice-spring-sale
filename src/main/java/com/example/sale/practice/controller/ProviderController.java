package com.example.sale.practice.controller;

import com.example.sale.practice.dto.ProviderDTO;
import com.example.sale.practice.dto.ResponseDTO;
import com.example.sale.practice.service.ProviderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAll() {
        var responseDTO = ResponseDTO.builder()
                .code(ResponseDTO.CODE_SUCCESS)
                .message(ResponseDTO.MESSAGE_SUCCESS)
                .content(providerService.getAll())
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> save(@Valid @RequestBody ProviderDTO dto) {
        var response = ResponseDTO.builder()
                .code(ResponseDTO.CODE_SUCCESS)
                .message(ResponseDTO.MESSAGE_SUCCESS)
                .content(providerService.save(dto))
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update(@Valid @RequestBody ProviderDTO dto, @PathVariable Long id) {
        var response = ResponseDTO.builder()
                .code(ResponseDTO.CODE_SUCCESS)
                .message(ResponseDTO.MESSAGE_SUCCESS)
                .content(providerService.update(dto, id))
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
