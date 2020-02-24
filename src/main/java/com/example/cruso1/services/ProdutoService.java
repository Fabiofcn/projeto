package com.example.cruso1.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.cruso1.Repositories.ProdutoRepository;
import com.example.cruso1.entities.Produto;
import com.example.cruso1.services.exceptions.DatabaseException;
import com.example.cruso1.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public List<Produto> buscaTudo(){
		return repo.findAll();
	}
	
	public Produto buscaById(Long id) {
		Optional<Produto> op = repo.findById(id);
		return op.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public void delete(Long id) {
		try {
		repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	public Produto inserir(Produto prod) {
		return repo.save(prod);
	}
	public Produto update(Long id, Produto pro) {
		try {
		Produto entity = repo.getOne(id);
		updateData(entity,pro);
		return repo.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Produto entity, Produto pro) {
		entity.setNome(pro.getNome());
		entity.setPreco(pro.getPreco());
		entity.setEstoque(pro.getEstoque());
		
	}
}
