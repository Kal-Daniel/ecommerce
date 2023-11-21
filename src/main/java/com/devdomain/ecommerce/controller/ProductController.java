package com.devdomain.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdomain.ecommerce.dto.ProductDTO;
import com.devdomain.ecommerce.dto.ProductDTOall;
import com.devdomain.ecommerce.entities.Product;
import com.devdomain.ecommerce.services.ProductService;

@RestController
@RequestMapping(value = "/produtos")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	@RequestMapping(value="{id}")
	public ProductDTOall findById(@PathVariable Long id) {
		Product product = productService.findById(id);
		ProductDTOall teste = new ProductDTOall(product);
		return teste;
	}
	
	@GetMapping
	public List<ProductDTO> findAll(){
		List<ProductDTO> result = productService.findAll();
		return result;
	}
	
	
}
