package com.example.projectbackend.service;

import java.util.List;

import com.example.projectbackend.model.Booking;

import dto.BookingDto;

public interface BookingService {
	
	public List<Booking> findAll();
	
	public String regBooking(Booking reg);

	public String updBooking(Booking req);

	public String delBooking(String id);

	public List<BookingDto> getTransactionCodeByDto(String transactionCode);
}
