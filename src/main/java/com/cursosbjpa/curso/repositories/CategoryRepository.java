package com.cursosbjpa.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursosbjpa.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
		
	
}
