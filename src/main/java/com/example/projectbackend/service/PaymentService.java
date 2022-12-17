package com.example.projectbackend.service;

import java.util.List;

import com.example.projectbackend.model.Payment;

public interface PaymentService {
	
	public List<Payment> findAll();
	
	public String regPayment(Payment reg);

	public String updPayment(Payment req);

	public String delPayment(String id);
}
