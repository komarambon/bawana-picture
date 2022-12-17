package com.example.projectbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "PAYMENT_METHOD", schema = "HR")
@Entity
public class PaymentMethod {
	
	@Id
	@Column(name = "ID_PAYMENTMETHOD")
	private String idPaymentmethod;
	
	@Column(name = "NAME_PAYMENTMETHOD")
	private String namePaymentmethod;

	public String getIdPaymentmethod() {
		return idPaymentmethod;
	}

	public void setIdPaymentmethod(String idPaymentmethod) {
		this.idPaymentmethod = idPaymentmethod;
	}

	public String getNamePaymentmethod() {
		return namePaymentmethod;
	}

	public void setNamePaymentmethod(String namePaymentmethod) {
		this.namePaymentmethod = namePaymentmethod;
	}

}
