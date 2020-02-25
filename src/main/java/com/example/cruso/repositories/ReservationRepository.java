package com.example.cruso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cruso.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
