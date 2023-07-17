package com.example.sale.practice.repository;

import com.example.sale.practice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ProductRepository extends JpaRepository<Product, Long> {
}
