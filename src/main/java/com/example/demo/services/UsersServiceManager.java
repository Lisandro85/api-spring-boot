package com.example.demo.services;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Users updateUser(Long id, Users user) {
        Users userExist= this.repository.findById(id).get();

        userExist.setName(user.getName());
        userExist.setLastName(user.getLastName());
        userExist.setAge(user.getAge());
        userExist.setEmail(user.getEmail());
        userExist.setIsActive(user.getIsActive());

        return this.repository.save(userExist);

    }
}
