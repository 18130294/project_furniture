package com.example.furniture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.furniture.model.Users;

public interface UserRepository extends JpaRepository<Users, String> {
	public Users findByEmail(String email);
}
