package com.example.sale.practice.service.impl;

import com.example.sale.practice.dto.ProductDTO;
import com.example.sale.practice.dto.ProviderDTO;
import com.example.sale.practice.entity.Product;
import com.example.sale.practice.entity.Provider;
import com.example.sale.practice.exception.RequestException;
import com.example.sale.practice.repository.ProductRepository;
import com.example.sale.practice.service.ProductService;
import com.example.sale.practice.service.ProviderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO save(ProductDTO dto) {
        Product product = modelMapper.map(dto, Product.class);
        ProviderDTO providerDTO = providerService.getById(dto.getProvider().getId());

        product.setProvider(modelMapper.map(providerDTO, Provider.class));
        productRepository.save(product);

        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO update(ProductDTO dto, Long idProduct) {
        ProductDTO productDTO = getById(idProduct);

        productDTO.setProvider(dto.getProvider());
        productDTO.setName(dto.getName());
        productDTO.setPrice(dto.getPrice());
        productDTO.setDescription(dto.getDescription());

        return save(productDTO);
    }

    @Override
    public ProductDTO getById(Long idProduct) {
        Product product = productRepository.findById(idProduct)
                .orElseThrow(() -> new RequestException("product not found with id: " + idProduct));

        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public void delete(Long idProduct) {
        ProductDTO productDTO = getById(idProduct);
        productRepository.deleteById(productDTO.getId());
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(el -> modelMapper.map(el, ProductDTO.class)).collect(Collectors.toList());
    }
}
