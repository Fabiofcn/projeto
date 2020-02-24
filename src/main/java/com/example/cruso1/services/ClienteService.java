package com.example.cruso1.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.cruso1.Repositories.ClienteRepository;
import com.example.cruso1.entities.Cliente;
import com.example.cruso1.services.exceptions.DatabaseException;
import com.example.cruso1.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public List<Cliente> buscatudo() {
		return repo.findAll();
	}

	public Cliente buscaById(Long id) {
		Optional<Cliente> op = repo.findById(id);
		return op.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Cliente insert(Cliente cliente) {
		return repo.save(cliente);
	}

	public void Deletar(Long id) {
		try {
			repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Cliente update(Long id, Cliente cli) {
		
		try {
			Cliente entity = repo.getOne(id);
			if(buscaById(id) != null ){//&& "".equals(buscaById(id))				
				updateData(entity, cli);	
			}
			
			return repo.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
		entity.setTelefone(obj.getTelefone());
		entity.setSenha(obj.getSenha());

	}

}
