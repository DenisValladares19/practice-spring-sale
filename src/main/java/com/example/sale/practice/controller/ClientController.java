package com.example.sale.practice.controller;

import com.example.sale.practice.dto.ClientDTO;
import com.example.sale.practice.dto.ResponseDTO;
import com.example.sale.practice.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@Valid  @RequestBody ClientDTO dto) {
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
        responseDTO.setMessage(ResponseDTO.MESSAGE_SUCCESS);
        responseDTO.setContent(clientService.create(dto));

        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable Long idClient) {
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
        responseDTO.setMessage(ResponseDTO.MESSAGE_SUCCESS);
        responseDTO.setContent(clientService.findById(idClient));

        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}
