package com.devdomain.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devdomain.ecommerce.dto.ProductDTO;
import com.devdomain.ecommerce.entities.Product;
import com.devdomain.ecommerce.projections.ProductProjection;
import com.devdomain.ecommerce.repositories.ProductRepository;
import com.devdomain.ecommerce.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return productRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Id não encontrado: " + id));
	}
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> result = productRepository.findAll();
		return result.stream().map(item -> new ProductDTO(item)).toList();
	}
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findByList(Long listId) {
		List<ProductProjection> result = productRepository.searchByList(listId);
		if (result.isEmpty()) {
			throw new ResourceNotFoundException("Id não encontrado: " + listId);
		}
		return result.stream().map(item -> new ProductDTO(item)).toList();
	}
	
	@Transactional(readOnly= true)
	public Product inserir(Product product) {
		return productRepository.save(product);
	}
	
	public void delete (Long id) {
		Product product = productRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Id não encontrado: " + id));

	    productRepository.delete(product);
	}
}
