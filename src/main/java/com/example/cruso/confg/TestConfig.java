package com.example.cruso.confg;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.cruso.entities.Reservation;
import com.example.cruso.repositories.ReservationRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	/*@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;
	*/
	@Autowired
	private ReservationRepository reservationRepository;
	@Override
	public void run(String... args) throws Exception {
		Reservation r1 = new Reservation(null,8021, Instant.parse("2019-09-23T10:53:07Z"), Instant.parse("2019-06-20T21:53:07Z")); 
		Reservation r2 = new Reservation(null,2, Instant.parse("2019-09-26T11:53:07Z"), Instant.parse("2019-06-20T22:53:07Z"));
		reservationRepository.saveAll(Arrays.asList(r1,r2));
		/*	Usuario u1 = new Usuario(null, "nome1", "email", "phone", "password");
		Usuario u2 = new Usuario(null, "nome2", "email", "phone", "password");
		Usuario u3 = new Usuario(null, "nome3", "email", "phone", "password");
		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Animal a1 = new Animal(null, "nome1", "especie", 1);
		Animal a2 = new Animal(null, "nome2", "especie", 2);
		Animal a3 = new Animal(null, "nome3", "especie", 3);
		animalRepository.saveAll(Arrays.asList(a1,a2,a3));
		
		Veiculo v1 = new Veiculo(null, "nome1", "especie", "1");
		Veiculo v2 = new Veiculo(null, "nome2", "especie", "2");
		Veiculo v3 = new Veiculo(null, "nome3", "especie", "3");
		veiculoRepository.saveAll(Arrays.asList(v1,v2,v3));
		
	*/}
	

}
