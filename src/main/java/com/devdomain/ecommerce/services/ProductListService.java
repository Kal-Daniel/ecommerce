package com.devdomain.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devdomain.ecommerce.dto.ProductListDTO;
import com.devdomain.ecommerce.entities.ProductList;
import com.devdomain.ecommerce.repositories.ProductListRepository;

@Service
public class ProductListService {
	
	@Autowired
	private ProductListRepository productListRepository;
	
	@Transactional(readOnly = true)
	public List<ProductListDTO> findAll(){
		List<ProductList> result = productListRepository.findAll();
		return result.stream().map(item -> new ProductListDTO(item)).toList();
	}
}
