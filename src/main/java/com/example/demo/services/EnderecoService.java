package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.services.exceptions.DatabaseException;
import com.example.demo.services.exceptions.ResourceNotFoundException;
import com.project.demo.dominio.Usuario;

@Service
public class EnderecoService {
	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Usuario insert(Usuario obj) {
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

	public Usuario update(Long id, Usuario obj) {
		try {
			Usuario entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setNomeEmpresa(obj.getNomeEmpresa());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		entity.setNomeResponsavel(obj.getNomeResponsavel());
		entity.setCnpj(obj.getCnpj());
	}
}
