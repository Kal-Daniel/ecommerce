package com.devdomain.ecommerce.dto;
import com.devdomain.ecommerce.entities.Product;

public class ProductDTO {

	private Long id;
	private String name;
	private Double price;
	private String imgUrl;
	private String shortDescription;
	
	public ProductDTO() {
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}

	
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
}
