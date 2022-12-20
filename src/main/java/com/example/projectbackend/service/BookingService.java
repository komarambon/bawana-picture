package com.example.projectbackend.service;

import java.io.IOException;
import java.util.List;

import com.example.projectbackend.model.Booking;

import net.sf.jasperreports.engine.JRException;

//import dto.BookingDto;

public interface BookingService {
	
	public List<Booking> findAll();
	
	public String regBooking(Booking reg);

	public String updBooking(Booking req);

	public String delBooking(String id);
	
	public Booking getTransactionCodeByIdTransactionCode(String transactionCode);
	
	public byte[] getInvoice() throws IOException, JRException;
//	public List<BookingDto> getTransactionCodeByDto(String transactionCode);
}
