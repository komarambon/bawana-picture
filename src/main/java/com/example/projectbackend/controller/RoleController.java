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

import com.example.projectbackend.model.Role;
import com.example.projectbackend.service.RoleService;

@CrossOrigin
@RestController
@RequestMapping("api/projectbackend/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@GetMapping
	public List<Role> findAll(){
		return roleService.findAll();
	}
	@PostMapping
	public String regRole(@RequestBody Role reg) {
		return roleService.regRole(reg);
	}
	@PutMapping
	public String updRole(@RequestBody Role reg) {
		return roleService.regRole(reg);
	}
	@DeleteMapping("{idRole}")
	public String delRole(@PathVariable String idRole){
		return roleService.delRole(idRole);
	}
	
}
	
