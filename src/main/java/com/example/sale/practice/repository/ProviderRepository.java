package com.example.sale.practice.repository;

import com.example.sale.practice.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository  extends JpaRepository<Provider, Long> {
}
