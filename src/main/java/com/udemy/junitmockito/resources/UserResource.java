package com.udemy.junitmockito.resources;

import com.udemy.junitmockito.models.User;
import com.udemy.junitmockito.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> userList = userService.findAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }
}
