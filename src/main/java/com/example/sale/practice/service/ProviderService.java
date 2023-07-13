package com.example.sale.practice.service;

import com.example.sale.practice.dto.ProviderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProviderService {
    List<ProviderDTO> getAll();
    ProviderDTO save(ProviderDTO dto);
    ProviderDTO update(ProviderDTO dto,  Long idProvider);

    void delete(Long idProvider);
    ProviderDTO getById(Long idProvider);
}
