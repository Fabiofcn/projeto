package com.example.cruso.resources;

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

import com.example.cruso.entities.Reservation;
import com.example.cruso.server.ReservationServer;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationResouce {

	@Autowired
	private ReservationServer reservationServer;
	
	@GetMapping
	public ResponseEntity<List<Reservation>> buscatudo(){
		List<Reservation> list = reservationServer.buscatudo();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Reservation> buscaByid(@PathVariable Long id){
		Reservation reservation = reservationServer.buscabyid(id);
		return ResponseEntity.ok().body(reservation);
	}
	@PostMapping
	public ResponseEntity<Reservation> duration(@RequestBody Reservation reservation){
		reservation = reservationServer.duration(reservation);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reservation.getRoomNumber()).toUri();
		return ResponseEntity.created(uri).body(reservation);
	}
	
	@DeleteMapping 
	public ResponseEntity<Void> cancelar(@PathVariable Long id){
		reservationServer.cancelar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Reservation> update(@PathVariable Long id, @RequestBody Reservation obj){
		obj = reservationServer.alterarReserva(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
