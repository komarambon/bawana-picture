package com.example.projectbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectbackend.model.Payment;
import com.example.projectbackend.repository.PaymentRepository;
import com.example.projectbackend.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	public List<Payment> findAll() {
		
		return paymentRepository.findAll();
	}
	@Override
	public String regPayment(Payment req) {
		String result = "Failed to register!";
		if(req != null) {
			paymentRepository.save(req);
			result = "Success to Register";
		}
		return result;
	}
	@Override
	public String updPayment(Payment req) {
		String result = "Failed to update data";
		
		Optional<Payment> optPayment =
			paymentRepository.findById(req.getIdPayment());
		
		if(optPayment.isPresent()) {
			paymentRepository.save(req);
			result = "Berhasil terupdate";
		}
		return result;
	}
	@Override
	public String delPayment(String id) {
		String result = "Failed to delete data";
		
		Optional<Payment> optPayment = 
				paymentRepository.findById(id);
		
		if(optPayment.isPresent()) {
			paymentRepository.deleteById(id);
			result = "Berhasil terdelete";
		}
		
		return result;
		}
	}

