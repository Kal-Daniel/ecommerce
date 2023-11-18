package com.devdomain.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devdomain.ecommerce.dto.ProductDTO;
import com.devdomain.ecommerce.entities.Product;
import com.devdomain.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDTO> findAll(){
		List<Product> result = productRepository.findAll();
		return result.stream().map(item -> new ProductDTO(item)).toList();
	}
}
