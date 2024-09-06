package com.cdac.MySpringBootDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.MySpringBootDemo.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
