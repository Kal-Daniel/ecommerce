package com.devdomain.ecommerce.dto;
import com.devdomain.ecommerce.entities.Product;
import com.devdomain.ecommerce.projections.ProductProjection;

public class ProductDTO {

	private Long id;
	private String name;
	private Double price;
	private String imgUrl;
	private Integer quantity;
	private String shortDescription;
	
	public ProductDTO() {
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
		quantity = entity.getQuantity();
		shortDescription = entity.getShortDescription();
	}
	
	public ProductDTO(ProductProjection projection) {
		id = projection.getId();
		name = projection.getName();
		price = projection.getPrice();
		imgUrl = projection.getImgUrl();
		quantity = projection.getQuantity();
		shortDescription = projection.getText();
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
	
	public Integer getQuantity() {
		return quantity;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
}
