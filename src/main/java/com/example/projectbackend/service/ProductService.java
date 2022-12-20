package com.example.projectbackend.service;

import java.util.List;

import com.example.projectbackend.model.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public String regProduct(Product reg);

	public String updProduct(Product req);

	public String delProduct(String id);
	
	public Product getPenggunaById(String idProduct);
}
