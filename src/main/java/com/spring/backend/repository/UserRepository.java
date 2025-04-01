package com.spring.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}