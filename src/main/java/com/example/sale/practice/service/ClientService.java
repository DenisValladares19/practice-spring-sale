package com.example.sale.practice.service;

import com.example.sale.practice.dto.ClientDTO;

public interface ClientService {
    ClientDTO create(ClientDTO dto);
    ClientDTO update(ClientDTO dto);
    ClientDTO findById(Long idClient);
    void delete(Long idClient);
}
