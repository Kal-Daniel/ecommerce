package com.devdomain.ecommerce.dto;

import com.devdomain.ecommerce.entities.ProductList;

public class ProductListDTO {
		private Long id;
		private String name;
		
		public ProductListDTO() {
		}

		public ProductListDTO(ProductList productList) {
			id = productList.getId();
			name = productList.getName();
		}

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}
		
}
