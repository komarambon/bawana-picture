package com.example.projectbackend.controller;

import java.io.IOException;
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
import com.example.projectbackend.service.impl.BookingServiceImpl;

import dto.BookingDto;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@CrossOrigin
@RestController
@RequestMapping("api/projectbackend/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	BookingServiceImpl bookingServiceImpl;
	
	@Autowired
	private HttpServletResponse response;
	
	@GetMapping(value="/report/{transactionCode}")
	public void getProductReport() throws Exception{
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition","attachment; filename=\"BookingInvoice.pdf\"");
		JasperPrint jasperPrint = bookingServiceImpl.generateJasperPrint();
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	
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
	@GetMapping(value="/{transactionCode}")
	public Booking getTransactionCodeByIdTransactionCode(@PathVariable String transactionCode) {
		return bookingService.getTransactionCodeByIdTransactionCode(transactionCode);
	}
	@GetMapping("/invoice/{transactionCode}")
		public byte[] getInvoice() throws IOException, JRException {
			return bookingService.getInvoice();
	}
	
	
//	@PostMapping("/transactionCode")
//	public List<BookingDto> getidBookingByDto(@PathVariable String transactionCode){
//		return bookingService.getTransactionCodeByDto(transactionCode);
//	}
}
	
