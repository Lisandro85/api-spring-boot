package com.example.demo.services;

import com.example.demo.entities.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<Users> findAll();

    Optional<Users> findById(Long id);

    Users save(Users user);

    Users updateUser (Long id, Users user);

    void deleteUser(long id);
}
