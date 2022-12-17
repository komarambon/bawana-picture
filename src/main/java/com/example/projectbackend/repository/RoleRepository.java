package com.example.projectbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectbackend.model.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

}
