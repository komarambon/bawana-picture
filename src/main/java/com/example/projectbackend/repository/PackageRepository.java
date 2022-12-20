package com.example.projectbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectbackend.model.Package;

public interface PackageRepository extends JpaRepository<Package, String>{

	public Package findByIdPackage(String idPackage);
	
	Optional<Package> findByNamaPackage(String namaPackage);
	
}
