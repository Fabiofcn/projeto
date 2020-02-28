package com.example.cruso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.cruso.entities.Conta;
import com.example.cruso.server.ContaServer;

@RestController
@RequestMapping(value = "/conta")
public class ContaResource {
	@Autowired
	private ContaServer ser;
	
	@GetMapping
	public ResponseEntity<List<Conta>> buscatudo(){
		List<Conta> list = ser.buscatudo();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Conta> duration(@RequestBody Double valor, Conta acc){
	    ser.deposita(valor);
	   
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(acc.getNumeroConta()).toUri();
		return ResponseEntity.ok().body(acc);
	}
	
}
