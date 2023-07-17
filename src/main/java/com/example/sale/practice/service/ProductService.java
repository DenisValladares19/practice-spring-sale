package com.example.sale.practice.service;

import com.example.sale.practice.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO save(ProductDTO dto);
    ProductDTO update(ProductDTO dto,  Long idProduct);
    ProductDTO getById(Long idProduct);
    void delete(Long idProduct);

    List<ProductDTO> getAll();
}
