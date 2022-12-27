package com.example.projectbackend.service;

import java.util.List;
import java.util.Optional;

import com.example.projectbackend.model.Pengguna;

public interface UserService {

	public List<Pengguna> findAll();

	public String regPengguna(Pengguna reg);
	
	public String updPengguna(Pengguna reg);

	public String delPengguna(String idUser);

	public Pengguna getPenggunaById(String idUser);
	
	public Pengguna getPenggunaByEmail(String email);
	
	public boolean isPasswordMatch(String email, String password);

}
