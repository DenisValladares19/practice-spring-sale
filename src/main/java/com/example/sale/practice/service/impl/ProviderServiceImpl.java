package com.example.sale.practice.service.impl;

import com.example.sale.practice.dto.ProviderDTO;
import com.example.sale.practice.entity.Provider;
import com.example.sale.practice.exception.RequestException;
import com.example.sale.practice.repository.ProviderRepository;
import com.example.sale.practice.service.ProviderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderServiceImpl  implements ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<ProviderDTO> getAll() {
        return providerRepository.findAll()
                .stream()
                .map(el -> modelMapper.map(el,ProviderDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProviderDTO save(ProviderDTO dto) {
        Provider provider = providerRepository.save(modelMapper.map(dto, Provider.class));
        return modelMapper.map(provider, ProviderDTO.class);
    }

    @Override
    public ProviderDTO update(ProviderDTO dto, Long idProvider) {
        if (idProvider == null) {
            throw new RequestException("id is required", "400");
        }

        Provider found = providerRepository.findById(idProvider)
                .orElseThrow(() -> {
                    throw  new RequestException("Provider not found", "400");
                });

        return save(modelMapper.map(found, ProviderDTO.class));
    }

    @Override
    public void delete(Long idProvider) {
        if (idProvider == null) {
            throw new RequestException("id is required", "400");
        }

        Provider found = providerRepository.findById(idProvider)
                .orElseThrow(() -> {
                    throw  new RequestException("Provider not found", "400");
                });

        providerRepository.delete(found);
    }

    @Override
    public ProviderDTO getById(Long idProvider) {
        if (idProvider == null) {
            throw new RequestException("id is required", "400");
        }

        Provider found = providerRepository.findById(idProvider)
                .orElseThrow(() -> {
                    throw  new RequestException("Provider not found", "400");
                });

        return modelMapper.map(found, ProviderDTO.class);
    }
}
