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

import com.example.projectbackend.model.Product;
import com.example.projectbackend.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("api/projectbackend/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> findAll(){
		return productService.findAll();
	}
	@PostMapping
	public String regProduct(@RequestBody Product reg) {
		return productService.regProduct(reg);
	}
	@PutMapping
	public String updProduct(@RequestBody Product reg) {
		return productService.regProduct(reg);
	}
	@DeleteMapping("{idProduct}")
	public String delProduct(@PathVariable String idProduct){
		return productService.delProduct(idProduct);
	}
	@PostMapping("{idProduct}")
	public Product getPenggunaById(@PathVariable String idProduct){
		return productService.getPenggunaById(idProduct);
	}
}
	
