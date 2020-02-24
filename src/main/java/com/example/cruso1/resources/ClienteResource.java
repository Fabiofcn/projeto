package com.example.cruso1.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.cruso1.entities.Cliente;
import com.example.cruso1.services.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService serv;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> buscaTudo(){
		List<Cliente> list = serv.buscatudo();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> buscaById(@PathVariable Long id){
		Cliente cliente = serv.buscaById(id);
		return ResponseEntity.ok().body(cliente);
		
	}
	@PostMapping
	public ResponseEntity<Cliente> incluir(@RequestBody Cliente cliente){
		cliente = serv.insert(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.ok().body(cliente);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		serv.Deletar(id);
		return ResponseEntity.noContent().build();
		
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente obj){
		obj = serv.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
