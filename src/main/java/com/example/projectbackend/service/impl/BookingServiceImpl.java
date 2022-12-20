package com.example.projectbackend.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.projectbackend.model.Package;
import com.example.projectbackend.model.Booking;
import com.example.projectbackend.model.Payment;
import com.example.projectbackend.model.PaymentMethod;
import com.example.projectbackend.model.Pengguna;
import com.example.projectbackend.model.Product;
import com.example.projectbackend.repository.BookingRepository;
import com.example.projectbackend.repository.PackageRepository;
import com.example.projectbackend.repository.PaymentMethodRepository;
import com.example.projectbackend.repository.PaymentRepository;
import com.example.projectbackend.repository.ProductRepository;
import com.example.projectbackend.repository.UserRepository;
import com.example.projectbackend.service.BookingService;

import dto.BookingDto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

//import dto.BookingDto;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PackageRepository packageRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	PaymentMethodRepository paymentMethodRepository;
	
	@Autowired
	private DataSource dataSource;
	
	private Connection getConnection() {
		try {
			return dataSource.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public JasperPrint generateJasperPrint() throws Exception{
		InputStream fileReport = new ClassPathResource("/templates/BawanaPictureInvoice.jasper").getInputStream();
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, getConnection());
			return jasperPrint;
	}
	
	@Override
	public List<Booking> findAll() {
		
		return bookingRepository.findAll();
	}
	@Override
	public String regBooking(Booking req) {
		String result = "Failed to register!";
		if(req != null) {
			bookingRepository.save(req);
			result = "Success to Register";
		}
		return result;
	}
	@Override
	public String updBooking(Booking req) {
		String result = "Failed to update data";
		
		Optional<Booking> optBooking =
			bookingRepository.findById(req.getTransactionCode());
		
		if(optBooking.isPresent()) {
			bookingRepository.save(req);
			result = "Berhasil terupdate";
		}
		return result;
	}
	@Override
	public String delBooking(String id) {
		String result = "Failed to delete data";
		
		Optional<Booking> optBooking = 
				bookingRepository.findById(id);
		
		if(optBooking.isPresent()) {
			bookingRepository.deleteById(id);
			result = "Berhasil terdelete";
		}
		
		return result;
		}
	@Override
	public Booking getTransactionCodeByIdTransactionCode(String transactionCode) {
		return bookingRepository.findByTransactionCode(transactionCode);
	}
	
	@Override
	public byte[] getInvoice() throws IOException, JRException {
		InputStream filePath = new ClassPathResource("/templates/BawanaPictureInvoice.jrxml").getInputStream();
		
		List<Booking> dsBooking = findAll();
		
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(dsBooking);
		
		JasperReport report = JasperCompileManager.compileReport(filePath);
		
		JasperPrint print = JasperFillManager.fillReport(report, null,ds);
		
		byte[]  byteArr = JasperExportManager.exportReportToPdf(print);
		
		return byteArr;
	}
//	@Override
//	public List<BookingDto> getTransactionCodeByDto(String transactionCode) {
//		List<BookingDto> bookingDto = new ArrayList<>();
//		List<Booking> bookingByIdBooking = bookingRepository.findByTransactionCode(transactionCode);
//		
//		for(Booking bookingByIdBookingLoop : bookingByIdBooking) {
//			BookingDto bookingDto2 = new BookingDto();
//		
//		Pengguna penggunaByidUser = userRepository
//				.findByIdUser(bookingByIdBookingLoop.getIdUser());
//		Package packageByidPackage = packageRepository
//				.findByIdPackage(bookingByIdBookingLoop.getIdPackage());
//		Payment paymentByidPayment = paymentRepository
//				.findByIdPayment(bookingByIdBookingLoop.getIdPayment());
//		PaymentMethod paymentMethodByidPaymentmethod = paymentMethodRepository
//				.findByIdPaymentmethod(paymentByidPayment.getIdPaymentmethod()); 
//		Product productByidProduct = productRepository
//				.findByIdProduct(packageByidPackage.getIdProduct());
//
//		bookingDto2.setTransactionCode(bookingByIdBookingLoop.getTransactionCode());
//		bookingDto2.setName(penggunaByidUser.getName());
//		bookingDto2.setNamaPackage(packageByidPackage.getNamaPackage());
//		bookingDto2.setNamaProduct(productByidProduct.getNamaProduct());
//		bookingDto2.setHarga(packageByidPackage.getHarga());
//		bookingDto2.setLokasiFoto(bookingByIdBookingLoop.getLokasiFoto());
//		bookingDto2.setTglFoto(bookingByIdBookingLoop.getTglFoto());
//		bookingDto2.setNamePaymentmethod(paymentMethodByidPaymentmethod.getNamePaymentmethod());
//		bookingDto.add(bookingDto2);
//		}
//		return bookingDto;
//	}

}

