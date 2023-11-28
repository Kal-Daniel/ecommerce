package com.devdomain.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devdomain.ecommerce.dto.ProductDTO;
import com.devdomain.ecommerce.entities.Product;
import com.devdomain.ecommerce.projections.ProductProjection;
import com.devdomain.ecommerce.repositories.ProductRepository;
import com.devdomain.ecommerce.services.exceptions.DatabaseException;
import com.devdomain.ecommerce.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		try {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id não encontrado: " + id));

            productRepository.delete(product);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
	
	@Transactional
	public Product update(Long id, Product product) {
	    try {
	        Product entity = productRepository.getReferenceById(id);
	        updateProduct(entity, product);
	        return productRepository.save(entity);
	    } catch (EntityNotFoundException ex) {
	        throw new ResourceNotFoundException("Id não encontrado: " + id);
	    }
	}


	private void updateProduct(Product entity, Product product) {
		entity.setName(product.getName());
		entity.setPrice(product.getPrice());
		entity.setImgUrl(product.getImgUrl());
		entity.setQuantity(product.getQuantity());
		entity.setShortDescription(product.getShortDescription());
	}
}
