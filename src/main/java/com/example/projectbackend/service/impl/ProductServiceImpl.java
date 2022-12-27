package com.example.projectbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectbackend.model.Product;
import com.example.projectbackend.repository.ProductRepository;
import com.example.projectbackend.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		
		return productRepository.findAll();
	}
	@Override
	public String regProduct(Product req) {
		String result = "Failed to register!";
		if(req != null) {
			productRepository.save(req);
			result = "Success to Register";
		}
		return result;
	}
	@Override
	public String updProduct(Product req) {
		String result = "Failed to update data";
		
		Optional<Product> optProduct =
			productRepository.findById(req.getIdProduct());
		
		if(optProduct.isPresent()) {
			productRepository.save(req);
			result = "Berhasil terupdate";
		}
		return result;
	}
	@Override
	public String delProduct(String id) {
		String result = "Failed to delete data";
		
		Optional<Product> optProduct = 
				productRepository.findById(id);
		
		if(optProduct.isPresent()) {
			productRepository.deleteById(id);
			result = "Berhasil terdelete";
		}
		
		return result;
		}
	@Override
	public Product getPenggunaById(String idProduct) {
		return productRepository.findByIdProduct(idProduct);
	}
	}

