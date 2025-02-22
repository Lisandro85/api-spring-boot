package com.example.demo.services;

import com.example.demo.entities.Users;

import java.util.List;

public interface UsersService {

    List<Users> findAll();

    Users findById(Long id);

    Users save(Users user);

    Users updateUser (Long id, Users user);
}
