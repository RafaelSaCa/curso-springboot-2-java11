package com.cursosbjpa.curso.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cursosbjpa.curso.entities.User;
import com.cursosbjpa.curso.repositories.UserRepository;
import com.cursosbjpa.curso.services.exceptions.DatabaseException;
import com.cursosbjpa.curso.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {// busca e traz do banco o objeto
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {// só prepara o objeto para atualização e depois efetua a operação no banco
		try {
			User entity = repository.getOne(id);
			UpdateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
				throw new ResourceNotFoundException(id);
		}

	}

	private void UpdateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
