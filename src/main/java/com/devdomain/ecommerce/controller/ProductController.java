package com.devdomain.ecommerce.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product pdc) {
		pdc = productService.inserir(pdc);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(pdc.getId()).toUri();
		return ResponseEntity.created(uri).body(pdc);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product){
		System.out.println("Chamando o método update com ID: " + id);
		product = productService.update(id, product);
		return ResponseEntity.ok().body(product);
	} 
}
