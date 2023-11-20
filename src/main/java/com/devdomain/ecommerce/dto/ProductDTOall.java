package com.devdomain.ecommerce.dto;

import org.springframework.beans.BeanUtils;

import com.devdomain.ecommerce.entities.Product;

public class ProductDTOall {
		private Long id;
		private String name;
		private Double price;
		private String imgUrl;
		private String shortDescription;
		
		public ProductDTOall() {
		}
		
		public ProductDTOall(Product entity) {
			BeanUtils.copyProperties(entity, this);
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getImgUrl() {
			return imgUrl;
		}

		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}

		public String getShortDescription() {
			return shortDescription;
		}

		public void setShortDescription(String shortDescription) {
			this.shortDescription = shortDescription;
		}
		
}
