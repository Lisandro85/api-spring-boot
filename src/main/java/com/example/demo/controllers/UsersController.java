package com.example.demo.controllers;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersServiceManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersServiceManager serviceManager;

    @GetMapping
    @Transactional(readOnly=true)
    public List<Users> findAllUsers(){
        return this.serviceManager.findAll();
    }

    @PostMapping
    @Transactional
    public Users save(@RequestBody Users user){
    return this.serviceManager.save(user);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public Users getByIdUser(@PathVariable Long id){
        return this.serviceManager.findById(id);
    }


}
