package com.example.projectbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectbackend.model.PaymentMethod;
import com.example.projectbackend.service.PaymentMethodService;

@CrossOrigin
@RestController
@RequestMapping("api/projectbackend/paymentMethod")
public class PaymentMethodController {
	
	@Autowired
	PaymentMethodService paymentMethodService;
	
	@GetMapping
	public List<PaymentMethod> findAll(){
		return paymentMethodService.findAll();
	}
	@PostMapping
	public String regPaymentMethod(@RequestBody PaymentMethod reg) {
		return paymentMethodService.regPaymentMethod(reg);
	}
	@PutMapping
	public String updPaymentMethod(@RequestBody PaymentMethod reg) {
		return paymentMethodService.regPaymentMethod(reg);
	}
	@DeleteMapping("{idPaymentmethod}")
	public String delPaymentMethod(@PathVariable String idPaymentmethod){
		return paymentMethodService.delPaymentMethod(idPaymentmethod);
	}
	
}
	
