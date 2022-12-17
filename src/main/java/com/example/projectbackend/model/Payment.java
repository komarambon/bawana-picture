package com.example.projectbackend.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "PAYMENT", schema = "HR")
@Entity
public class Payment {

	@Id
	@Column(name = "ID_PAYMENT")
	private String idPayment;
	
	@Column(name = "ID_PAYMENTMETHOD")
	private String idPaymentmethod;
	
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;
	
	@Column(name = "IS_PAID")
	private String isPaid;

	public String getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(String idPayment) {
		this.idPayment = idPayment;
	}

	public String getIdPaymentmethod() {
		return idPaymentmethod;
	}

	public void setIdPaymentmethod(String idPaymentmethod) {
		this.idPaymentmethod = idPaymentmethod;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}




}
