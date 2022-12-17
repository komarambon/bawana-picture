package com.example.projectbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectbackend.model.Role;
import com.example.projectbackend.repository.RoleRepository;
import com.example.projectbackend.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		
		return roleRepository.findAll();
	}
	@Override
	public String regRole(Role req) {
		String result = "Failed to register!";
		if(req != null) {
			roleRepository.save(req);
			result = "Success to Register";
		}
		return result;
	}
	@Override
	public String updRole(Role req) {
		String result = "Failed to update data";
		
		Optional<Role> optRole =
			roleRepository.findById(req.getIdRole());
		
		if(optRole.isPresent()) {
			roleRepository.save(req);
			result = "Berhasil terupdate";
		}
		return result;
	}
	@Override
	public String delRole(String id) {
		String result = "Failed to delete data";
		
		Optional<Role> optRole = 
				roleRepository.findById(id);
		
		if(optRole.isPresent()) {
			roleRepository.deleteById(id);
			result = "Berhasil terdelete";
		}
		
		return result;
		}
	}

