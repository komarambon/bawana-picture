package com.example.projectbackend.service;

import java.util.List;

import com.example.projectbackend.model.PaymentMethod;

public interface PaymentMethodService {

	public List<PaymentMethod> findAll();
	
	public String regPaymentMethod (PaymentMethod reg);

	public String updPaymentMethod (PaymentMethod req);

	public String delPaymentMethod (String id);
}
