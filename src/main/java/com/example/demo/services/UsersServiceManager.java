package com.example.demo.services;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceManager implements UsersService{

    @Autowired
    private  UsersRepository repository;

    @Override
    public List<Users> findAll() {
        return (List<Users>) this.repository.findAll();
    }

    @Override
    public Users findById(Long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Users save(Users user) {
        return this.repository.save(user);
    }
}
