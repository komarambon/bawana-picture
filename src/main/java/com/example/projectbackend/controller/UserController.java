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

import com.example.projectbackend.model.Pengguna;
import com.example.projectbackend.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("api/projectbackend/pengguna")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public List<Pengguna> findAll(){
		return userService.findAll();
	}
	@PostMapping
	public String regPengguna(@RequestBody Pengguna reg) {
		return userService.regPengguna(reg);
	}
	@PutMapping
	public String updPengguna(@RequestBody Pengguna reg) {
		return userService.regPengguna(reg);
	}
	@DeleteMapping("{idUser}")
	public String delPengguna(@PathVariable String idUser){
		return userService.delPengguna(idUser);
	}
	@GetMapping("{idUser}")
	public Pengguna getPenggunaById(@PathVariable String idUser){
		return userService.getPenggunaById(idUser);
	}
	@PostMapping(value="{email}")
	public List<Pengguna> getPenggunaByemail(@PathVariable String email){
		return userService.getPenggunaByEmail(email);
	}
}
