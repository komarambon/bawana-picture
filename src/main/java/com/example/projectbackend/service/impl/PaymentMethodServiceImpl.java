package com.example.projectbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectbackend.model.PaymentMethod;
import com.example.projectbackend.repository.PaymentMethodRepository;
import com.example.projectbackend.service.PaymentMethodService;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService{
	
	@Autowired
	PaymentMethodRepository paymentMethodRepository;
	
	@Override
	public List<PaymentMethod> findAll() {
		
		return paymentMethodRepository.findAll();
	}
	@Override
	public String regPaymentMethod(PaymentMethod req) {
		String result = "Failed to register!";
		if(req != null) {
			paymentMethodRepository.save(req);
			result = "Success to Register";
		}
		return result;
	}
	@Override
	public String updPaymentMethod(PaymentMethod req) {
		String result = "Failed to update data";
		
		Optional<PaymentMethod> optPaymentMethod =
			paymentMethodRepository.findById(req.getIdPaymentmethod());
		
		if(optPaymentMethod.isPresent()) {
			paymentMethodRepository.save(req);
			result = "Berhasil terupdate";
		}
		return result;
	}
	@Override
	public String delPaymentMethod(String id) {
		String result = "Failed to delete data";
		
		Optional<PaymentMethod> optPaymentMethod = 
				paymentMethodRepository.findById(id);
		
		if(optPaymentMethod.isPresent()) {
			paymentMethodRepository.deleteById(id);
			result = "Berhasil terdelete";
		}
		
		return result;
		}
	}

