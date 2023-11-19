package com.devdomain.ecommerce.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable //Encapsula dois elementos em uma só classe.
public class BelongingPK {
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="list_id")
	private ProductList list;
	
	public BelongingPK() {
	}

	public BelongingPK(Product product, ProductList list) {
		this.product = product;
		this.list = list;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductList getList() {
		return list;
	}

	public void setList(ProductList list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(list, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(list, other.list) && Objects.equals(product, other.product);
	}
	
}
