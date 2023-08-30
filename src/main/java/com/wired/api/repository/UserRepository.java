package com.wired.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wired.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
