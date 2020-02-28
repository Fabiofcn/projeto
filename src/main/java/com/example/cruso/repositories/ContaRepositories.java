package com.example.cruso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cruso.entities.Conta;

public interface ContaRepositories extends JpaRepository<Conta, Integer> {

}
