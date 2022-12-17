package com.example.projectbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectbackend.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, String>{
	
	public List<Booking> findByTransactionCode(String transactionCode);
}
