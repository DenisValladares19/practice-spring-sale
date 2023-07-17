package com.example.sale.practice.controller;

import com.example.sale.practice.dto.ProductDTO;
import com.example.sale.practice.dto.ResponseDTO;
import com.example.sale.practice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping
    public ResponseEntity<ResponseDTO> getAll() {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .code(ResponseDTO.CODE_SUCCESS)
                .message((ResponseDTO.MESSAGE_SUCCESS))
                .content(productService.getAll())
                .build();

        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> save(@Valid @RequestBody ProductDTO dto) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .code(ResponseDTO.CODE_SUCCESS)
                .message(ResponseDTO.MESSAGE_SUCCESS)
                .content(productService.save(dto))
                .build();

        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<ResponseDTO> update(@Valid @RequestBody ProductDTO dto, @PathVariable Long idProduct) {
        ResponseDTO<ProductDTO> response = new ResponseDTO<ProductDTO>();

        response.setCode(ResponseDTO.CODE_SUCCESS);
        response.setMessage(ResponseDTO.MESSAGE_SUCCESS);
        response.setContent(productService.update(dto, idProduct));

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long idProduct) {
        ResponseDTO response = new ResponseDTO();

        response.setCode(ResponseDTO.CODE_SUCCESS);
        response.setMessage(ResponseDTO.MESSAGE_SUCCESS);
        response.setContent(idProduct);

        return new ResponseEntity(response, HttpStatus.OK);
    }
}
