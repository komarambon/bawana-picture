package com.example.projectbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.projectbackend.model.Pengguna;
import com.example.projectbackend.repository.UserRepository;
import com.example.projectbackend.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Pengguna> findAll() {
		
		return userRepository.findAll();
	}
	
	@Override
	public String regPengguna(Pengguna req) {
		String result = "Failed to register!";
		if(req != null) {
			String password = req.getPassword();
			
			BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
			password = passEncoder.encode(password);
			
			req.setPassword(password);
			userRepository.save(req);
			result = "Pengguna Berhasil Terdaftar";
		}
		return result;
	}
	@Override
	public String updPengguna(Pengguna req) {
		String result = "Failed to update data";
		
		Optional<Pengguna> optUser =
			userRepository.findById(req.getIdUser());
		
		if(optUser.isPresent()) {
			userRepository.save(req);
			result = "Berhasil terupdate";
		}
		return result;
	}
	@Override
	public String delPengguna(String id) {
		String result = "Failed to delete data";
		
		Optional<Pengguna> optUser = 
				userRepository.findById(id);
		
		if(optUser.isPresent()) {
			userRepository.deleteById(id);
			result = "Berhasil terdelete";
		}
		
		return result;
		}
	@Override
	public Pengguna getPenggunaById(String idUser) {
		return userRepository.findByIdUser(idUser);
	}
	@Override
	public Pengguna getPenggunaByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Override
	public boolean isPasswordMatch(String email, String password) {
		boolean result = false;
		Pengguna isUserExists = userRepository.findByEmail(email);
		
		if(isUserExists != null) {
			Pengguna pengguna = isUserExists;
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			result = encoder.matches(password, pengguna.getPassword());
		}
		return result;
	}


}


