package com.cursosbjpa.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursosbjpa.curso.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
		
	
}
