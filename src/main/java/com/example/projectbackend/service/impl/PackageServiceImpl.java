package com.example.projectbackend.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.projectbackend.model.Package;
import com.example.projectbackend.model.Product;
import com.example.projectbackend.repository.PackageRepository;
import com.example.projectbackend.repository.ProductRepository;
import com.example.projectbackend.service.PackageService;
import com.example.projectbackend.util.PackageUtil;

//import dto.PackageDto;

@Service
public class PackageServiceImpl implements PackageService{
	
	@Autowired
	PackageRepository packageRepository;
	
	ProductRepository productRepository;
	
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
	public Package getPackageByidPackage(String idPackage) {
		return packageRepository.findByIdPackage(idPackage);
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
//	@Override
//	public List<PackageDto> getidPackageByDto(String idPackage) {
//		List <PackageDto> packageDto = new ArrayList<>();
//		List <Package> packageByIdPackage = packageRepository.findByIdPackage(idPackage);
//		
//		for(Package packageByIdPackageLoop : packageByIdPackage) {
//			PackageDto packageDto2 = new PackageDto();
//		
//		Product productByidProduct = productRepository
//					.findByIdProduct(packageByIdPackageLoop.getIdProduct());
//		
//		packageDto2.setIdPackage(packageByIdPackageLoop.getIdPackage());
//		packageDto2.setNamaPackage(packageByIdPackageLoop.getNamaPackage());
//		packageDto2.setIdProduct(packageByIdPackageLoop.getIdProduct());
//		packageDto2.setNamaProduct(productByidProduct.getNamaProduct());
//		packageDto2.setHarga(packageByIdPackageLoop.getHarga());
//		packageDto.add(packageDto2);
//		}
//		return packageDto;
//	}
	}


