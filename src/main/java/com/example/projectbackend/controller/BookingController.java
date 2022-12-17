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

import com.example.projectbackend.model.Booking;
import com.example.projectbackend.service.BookingService;

import dto.BookingDto;

@CrossOrigin
@RestController
@RequestMapping("api/projectbackend/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping
	public List<Booking> findAll(){
		return bookingService.findAll();
	}
	@PostMapping
	public String regBooking(@RequestBody Booking reg) {
		return bookingService.regBooking(reg);
	}
	@PutMapping
	public String updBooking(@RequestBody Booking reg) {
		return bookingService.regBooking(reg);
	}
	@DeleteMapping("{transactionCode}")
	public String delBooking(@PathVariable String transactionCode){
		return bookingService.delBooking(transactionCode);
	}
	@PostMapping("transactionCode/{transactionCode}")
	public List<BookingDto> getidBookingByDto(@PathVariable String transactionCode){
		return bookingService.getTransactionCodeByDto(transactionCode);
	}
}
	
