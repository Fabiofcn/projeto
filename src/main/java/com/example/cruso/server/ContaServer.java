package com.example.cruso.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruso.entities.Conta;
import com.example.cruso.repositories.ContaRepositories;

@Service
public class ContaServer {

	@Autowired
	private ContaRepositories repo;
	
	public List<Conta> buscatudo(){
		return repo.findAll();
	}
	
	public  void deposita(Double amount) {
	try {
		Conta acc = new Conta();
		repo.save(acc);
	}catch(Exception e) {
		e.printStackTrace(); 
	}
	}
	
}
