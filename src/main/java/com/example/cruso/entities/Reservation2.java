package com.example.cruso.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tb_reservation" )
public class Reservation2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int roomNumber;
	private Instant checkIn;
	private Instant checout;
	
	public Reservation2() {
		
	}

	public Reservation2(Long id,int roomNumber, Instant checkIn, Instant checout) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checout = checout;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Instant getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Instant checkIn) {
		this.checkIn = checkIn;
	}

	public Instant getChecout() {
		return checout;
	}

	public void setChecout(Instant checout) {
		this.checout = checout;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation2 other = (Reservation2) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	
}
