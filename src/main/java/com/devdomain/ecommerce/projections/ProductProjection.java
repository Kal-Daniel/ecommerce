package com.devdomain.ecommerce.projections;

public interface ProductProjection {
	Long getId();
	String getName();
	Double getPrice();
	String getImgUrl();
	Integer getQuantity();
	String getText();
	Integer getPosition();
}
