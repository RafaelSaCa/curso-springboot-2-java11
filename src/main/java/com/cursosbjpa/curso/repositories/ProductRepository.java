package com.cursosbjpa.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursosbjpa.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
		
	
}
