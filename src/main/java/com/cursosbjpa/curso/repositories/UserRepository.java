package com.cursosbjpa.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursosbjpa.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
		
	
}
