package com.cdac.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
