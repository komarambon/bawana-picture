package com.example.projectbackend.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "BOOKING", schema = "HR")
@Entity
public class Booking {

	@Id
	@Column(name = "TRANSACTION_CODE")
	private String transactionCode;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "TGL_FOTO")
	private Date tglFoto;
	
	@Column(name = "LOKASI_FOTO")
	private String lokasiFoto;
	
	@Column(name = "NAME_PACKAGE")
	private String namaPackage;
	
	@Column(name = "NAME_PAYMENTMETHOD")
	private String namePaymentmethod;
	
	@Column(name = "PRICE")
	private Integer price;
	
	@Column(name = "NAMA_PRODUCT")
	private String namaProduct;

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTglFoto() {
		return tglFoto;
	}

	public void setTglFoto(Date tglFoto) {
		this.tglFoto = tglFoto;
	}

	public String getLokasiFoto() {
		return lokasiFoto;
	}

	public void setLokasiFoto(String lokasiFoto) {
		this.lokasiFoto = lokasiFoto;
	}

	public String getNamaPackage() {
		return namaPackage;
	}

	public void setNamaPackage(String namaPackage) {
		this.namaPackage = namaPackage;
	}

	public String getNamePaymentmethod() {
		return namePaymentmethod;
	}

	public void setNamePaymentmethod(String namePaymentmethod) {
		this.namePaymentmethod = namePaymentmethod;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getNamaProduct() {
		return namaProduct;
	}

	public void setNamaProduct(String namaProduct) {
		this.namaProduct = namaProduct;
	}
	
}
