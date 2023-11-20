package com.devdomain.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdomain.ecommerce.dto.ProductListDTO;
import com.devdomain.ecommerce.services.ProductListService;

@RestController
@RequestMapping(value = "/lists")
public class ProductListController {
	
	@Autowired
	private ProductListService productListService;
	
	@GetMapping
	public List<ProductListDTO> findAll(){
		List<ProductListDTO> result = productListService.findAll();
		return result;
	}
}
