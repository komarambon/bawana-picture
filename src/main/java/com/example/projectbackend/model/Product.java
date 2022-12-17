package com.example.projectbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Product", schema = "HR")
@Entity
public class Product {
	
	@Id
	@Column(name = "ID_Product")
	private String idProduct;
	
	@Column(name = "NAMA_PRODUCT")
	private String namaProduct;

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getNamaProduct() {
		return namaProduct;
	}

	public void setNamaProduct(String namaProduct) {
		this.namaProduct = namaProduct;
	}

	
}
