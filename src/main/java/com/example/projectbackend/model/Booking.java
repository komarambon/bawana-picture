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
	
	@Column(name = "ID_USER")
	private String idUser;
	
	@Column(name = "TGL_FOTO")
	private Date tglFoto;
	
	@Column(name = "LOKASI_FOTO")
	private String lokasiFoto;
	
	@Column(name = "ID_PACKAGE")
	private String idPackage;
	
	@Column(name = "ID_PAYMENT")
	private String idPayment;

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
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

	public String getIdPackage() {
		return idPackage;
	}

	public void setIdPackage(String idPackage) {
		this.idPackage = idPackage;
	}

	public String getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(String idPayment) {
		this.idPayment = idPayment;
	}


	
}
