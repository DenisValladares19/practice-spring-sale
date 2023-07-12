package com.example.sale.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDTO {
    private Long id;
    private String name;
    private String address;

    private Date createdAt;

    private LocalDateTime updatedAt;

    private Set<ProductDTO> listProduct;
}
