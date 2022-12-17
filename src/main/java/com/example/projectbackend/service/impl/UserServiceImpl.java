package com.example.projectbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Pengguna> getPenggunaByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Override
	public boolean isPasswordMatch(String id, String password) {
		boolean result = false;
		Optional<Pengguna> isUserExists = userRepository.findById(id);
		
		if(isUserExists != null) {
			Pengguna pengguna = isUserExists.get();
		}
	}
	return false;


}