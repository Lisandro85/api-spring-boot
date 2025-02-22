package com.example.demo.controllers;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersServiceManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody Users user){
      Optional <Users> usersExist= Optional.of(this.serviceManager.findById(id));
      if(usersExist.isPresent()){
          Users newUser=usersExist.get();
          newUser.setName(user.getName());
          newUser.setLastName(user.getLastName());
          newUser.setEmail(user.getEmail());
          newUser.setAge(user.getAge());
          newUser.setIsActive(user.getIsActive());

          return ResponseEntity
                  .status(HttpStatus.CREATED)
                  .body(this.serviceManager.updateUser( id,newUser));
      }
      return ResponseEntity.notFound().build();
    }




}
