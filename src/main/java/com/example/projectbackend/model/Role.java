package com.example.projectbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "ROLE", schema = "HR")
@Entity
public class Role {
	
	@Id
	@Column(name = "ID_ROLE")
	private String idRole;
	
	@Column(name = "NAMA_ROLE")
	private String namaRole;

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public String getNamaRole() {
		return namaRole;
	}

	public void setNamaRole(String namaRole) {
		this.namaRole = namaRole;
	}
	
	
}
