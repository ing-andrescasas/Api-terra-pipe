package com.terrapipe.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terrapipe.app.model.entity.User;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private TerraPipeServiceIface terraService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> allUsers() {
        return ResponseEntity.ok(terraService.allUsers());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable Integer id){
        return ResponseEntity.ok(terraService.findUser(id));
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userCreated = terraService.saveUser(user);
        return  ResponseEntity.ok(userCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id)  {

        User userDelete = terraService.findUser(id);
        terraService.deleteUserById(id);;
        return ResponseEntity.ok(userDelete);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable Integer id, @RequestBody  User user) {
        try {
            User userExistente = terraService.findUser(id);

            if (user.getUserName()!= null && !user.getUserName().isEmpty())
            userExistente.setUserName(user.getUserName());
            if (user.getPassword()!= null && !user.getPassword().isEmpty())
            userExistente.setPassword(user.getPassword());


            userExistente.setStatus(user.isStatus());

            terraService.updateUser(userExistente);

            return ResponseEntity.ok(userExistente);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
