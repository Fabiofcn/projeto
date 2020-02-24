package com.example.cruso1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cruso1.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
