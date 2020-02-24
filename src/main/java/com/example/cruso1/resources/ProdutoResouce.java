package com.example.cruso1.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.cruso1.entities.Produto;
import com.example.cruso1.services.ProdutoService;
@RestController
@RequestMapping(value = "/produto")
public class ProdutoResouce  {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscaToda(){
		List<Produto> list = produtoService.buscaTudo();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscaById(@PathVariable Long id){
		Produto prod = produtoService.buscaById(id);
		return ResponseEntity.ok().body(prod);
	}
	@PostMapping
	public ResponseEntity<Produto> incerir(@RequestBody Produto prod){
		prod = produtoService.inserir(prod);
		URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prod.getId()).toUri();
		return ResponseEntity.created(url).body(prod);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
