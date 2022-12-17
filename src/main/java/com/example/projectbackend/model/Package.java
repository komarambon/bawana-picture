package com.example.projectbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "PACKAGE", schema = "HR")
@AllArgsConstructor
public class Package {
	
	@Id
	@Column(name = "ID_PACKAGE")
	private String idPackage;
	
	@Column(name = "NAME_Package")
	private String namaPackage;
	
	@Column(name = "TOTAL_PRICE")
	private Integer harga;
	
	@Column(name = "ID_PRODUCT")
	private String idProduct;
	
	@Column(name = "IMAGEPACKAGE")
	private byte[] imagePackage;

	public String getIdPackage() {
		return idPackage;
	}

	public void setIdPackage(String idPackage) {
		this.idPackage = idPackage;
	}

	public String getNamaPackage() {
		return namaPackage;
	}

	public void setNamaPackage(String namaPackage) {
		this.namaPackage = namaPackage;
	}

	public Integer getHarga() {
		return harga;
	}

	public void setHarga(Integer harga) {
		this.harga = harga;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public byte[] getImagePackage() {
		return imagePackage;
	}

	public void setImagePackage(byte[] imagePackage) {
		this.imagePackage = imagePackage;
	}

}
