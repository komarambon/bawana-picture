package com.example.projectbackend.service;

import java.util.List;

import com.example.projectbackend.model.Role;

public interface RoleService {
	
	public List<Role> findAll();
	
	public String regRole(Role reg);

	public String updRole(Role req);

	public String delRole(String id);
}
