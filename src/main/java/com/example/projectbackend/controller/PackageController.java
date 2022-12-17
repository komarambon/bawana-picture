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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import com.example.projectbackend.model.Package;
import com.example.projectbackend.service.PackageService;

@CrossOrigin
@RestController
@RequestMapping("api/projectbackend/package")
public class PackageController {
	
	@Autowired
	PackageService packageService;
	
	@GetMapping
	public List<Package> findAll(){
		return packageService.findAll();
	}
	@PostMapping("idProduct/{idProduct}")
	public List<Package> getPackageByidProduct(@PathVariable String idProduct){
		return packageService.getPackageByidProduct(idProduct);
	}
	@PostMapping
	public String regPackage(@RequestBody Package reg) {
		return packageService.regPackage(reg);
	}
	@PutMapping
	public String updPackage(@RequestBody Package reg) {
		return packageService.regPackage(reg);
	}
	@DeleteMapping("{idPackage}")
	public String delPackage(@PathVariable String idPackage){
		return packageService.delPackage(idPackage);
	}
	@PostMapping("imagePackage/imagePackage")
	public String uploadImage(@RequestParam ("imagePackage") MultipartFile file, String id) throws IOException {
		return packageService.uploadImage(file, id);
	}	
	@GetMapping("idPackage/{id}")
	public byte[] getPackageImageById(@PathVariable String id){
		return packageService.getPackageImageById(id);
	}
}
	
