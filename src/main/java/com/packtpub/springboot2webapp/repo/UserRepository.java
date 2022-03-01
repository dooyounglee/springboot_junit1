package com.packtpub.springboot2webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packtpub.springboot2webapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
