package com.example.demo.controllers;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersServiceManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersServiceManager serviceManager;

    //OBTENER LA LISTA DE USUARIOS:

    @GetMapping
    @Transactional(readOnly=true)
    public ResponseEntity<List<Users>> findAllUsers(){
        List<Users> users = this.serviceManager.findAll();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    //CREAR UN USUARIO:

    @PostMapping
    @Transactional
    public ResponseEntity<?> save(@RequestBody Users user) {
        try {
            Users savedUser = this.serviceManager.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage())); // Mensaje personalizado
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error al guardar el usuario"));
        }
    }


    //OBTENER USUARIO POR ID

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getByIdUser(@PathVariable Long id) {
        Optional<Users> user = this.serviceManager.findById(id);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Usuario no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }


    // ACTUALIIZAR UN USUARIO:

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody Users user) {
        Optional<Users> usersExist = this.serviceManager.findById(id);
        if (usersExist.isPresent()) {
            Users existingUser = usersExist.get();
            existingUser.setName(user.getName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setAge(user.getAge());
            existingUser.setIsActive(user.getIsActive());

            Users updatedUser = this.serviceManager.updateUser(id, existingUser);
            return ResponseEntity.ok(updatedUser); // HTTP 200 OK
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Usuario no encontrado"));
    }
//ELIIMINAR UN USUARIO

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteUser(@PathVariable Long id) {
    boolean deleted = serviceManager.deleteUser(id);
    if (deleted) {
        return ResponseEntity.ok(Map.of("message", "Usuario eliminado con éxito"));
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Usuario no encontrado"));
    }
}



}
