package com.devdomain.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devdomain.ecommerce.entities.ProductList;

public interface ProductListRepository extends JpaRepository<ProductList, Long> {

}
