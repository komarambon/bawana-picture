package com.example.projectbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectbackend.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String>{

	public Payment findByIdPayment(String idPayment);

}
