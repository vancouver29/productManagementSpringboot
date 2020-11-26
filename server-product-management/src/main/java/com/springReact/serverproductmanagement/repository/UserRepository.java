package com.springReact.serverproductmanagement.repository;

import com.springReact.serverproductmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //findBy + Username
    Optional<User> findByUsername(String username);
}
