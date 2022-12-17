package com.example.projectbackend.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.projectbackend.model.Package;
import com.example.projectbackend.repository.PackageRepository;
import com.example.projectbackend.service.PackageService;
import com.example.projectbackend.util.PackageUtil;

@Service
public class PackageServiceImpl implements PackageService{
	
	@Autowired
	PackageRepository packageRepository;
	
	PackageUtil packageUtil;
	
	@Override
	public List<Package> findAll() {
		
		return packageRepository.findAll();
	}
	@Override
	public String regPackage(Package req) {
		String result = "Failed to register!";
		if(req != null) {
			packageRepository.save(req);
			result = "Success to Register";
		}
		return result;
	}
	@Override
	public String updPackage(Package req) {
		String result = "Failed to update data";
		
		Optional<Package> optPackage =
			packageRepository.findById(req.getIdPackage());
		
		if(optPackage.isPresent()) {
			packageRepository.save(req);
			result = "Berhasil terupdate";
		}
		return result;
	}
	@Override
	public String delPackage(String id) {
		String result = "Failed to delete data";
		
		Optional<Package> optPackage = 
				packageRepository.findById(id);
		
		if(optPackage.isPresent()) {
			packageRepository.deleteById(id);
			result = "Berhasil terdelete";
		}
		
		return result;
		}
	@Override
	public List<Package> getPackageByidProduct(String idProduct) {
		return packageRepository.findByIdProduct(idProduct);
	}
	@Override
	public String uploadImage(MultipartFile file, String id) throws IOException {
		String result = "Failed to upload image";
		byte[] imageByte = packageUtil.compressImage(file.getBytes());
		
		Optional<Package> isPackageExt = packageRepository.findById(id);
		
		if(isPackageExt != null) {
			Package package1 = isPackageExt.get();
			package1.setImagePackage(imageByte);
			
			packageRepository.save(package1);
			result = "Success to upload image";
		}
		return result;
	}
	
	@Override
	public byte[] getPackageImageById(String idPackage) {
		byte[] result = null;
		Optional<Package> isPackageExt = packageRepository.findById(idPackage);
		
		if (isPackageExt != null) {
			Package package1 = isPackageExt.get();
			result = packageUtil.decompressImage(package1.getImagePackage());
		}
		return result;
	}
}

