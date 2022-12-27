package com.example.projectbackend.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectbackend.model.Pengguna;

public interface UserRepository extends JpaRepository<Pengguna, String>{

	public Pengguna findByIdUser(String idUser);
	
	public Pengguna findByEmail(String email);
}
