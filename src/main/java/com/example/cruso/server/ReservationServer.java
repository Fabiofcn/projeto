package com.example.cruso.server;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.cruso.entities.Reservation;
import com.example.cruso.repositories.ReservationRepository;
import com.example.cruso.services.exceptions.ResourceNotFoundException;

@Service
public class ReservationServer {
	@Autowired
	private ReservationRepository repo;
	
	public List<Reservation> buscatudo(){
		return repo.findAll();
	}
	
	public Reservation buscabyid(Long id) {
		Optional<Reservation> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Reservation duration(Reservation id) {
		int value = id.getCheckIn().compareTo(id.getChecout());
		
			if (value < 0)
				return repo.save(id);
			else
				return null;
		
		
	}
	
	public void cancelar(Long id) {
		try {
		repo.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);			
		}/*catch(DataIntegrityViolationException o) {
			throw new DatabaseException(o.getMessage());			
		}*/
	}
	
	public Reservation alterarReserva(Long id, Reservation obj) {
		Reservation entity = repo.getOne(id);
		updateData (entity,obj);
		return repo.save(entity);
		
	}
	public void updateData (Reservation entity, Reservation reservation) {
		entity.setCheckIn(reservation.getCheckIn());
		entity.setChecout(reservation.getChecout());
		entity.setRoomNumber(reservation.getRoomNumber());
	}

	
	

}
