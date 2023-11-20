package com.devdomain.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devdomain.ecommerce.dto.ProductDTO;
import com.devdomain.ecommerce.dto.ProductDTOall;
import com.devdomain.ecommerce.entities.Product;
import com.devdomain.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public ProductDTOall findById(Long id) {
		Product result = productRepository.findById(id).get();
		ProductDTOall dto = new ProductDTOall(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> result = productRepository.findAll();
		return result.stream().map(item -> new ProductDTO(item)).toList();
	}
}
