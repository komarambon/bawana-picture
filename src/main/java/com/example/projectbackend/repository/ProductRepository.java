package com.example.projectbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectbackend.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

	public Product findByIdProduct(String idProduct);


}
