package com.example.projectbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectbackend.model.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, String> {

	public PaymentMethod findByIdPaymentmethod(String idPaymentmethod);
}
