package com.example.projectbackend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.projectbackend.model.Package;

public interface PackageService {
	
	public List<Package> findAll();
	
	public String regPackage (Package reg);

	public String updPackage (Package req);

	public String delPackage (String id);

	public String uploadImage(MultipartFile file, String id) throws IOException;

	public byte[] getPackageImageById(String idPackage);

	public List<Package> getPackageByidProduct(String idProduct);
	
}
