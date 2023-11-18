package com.devdomain.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devdomain.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
