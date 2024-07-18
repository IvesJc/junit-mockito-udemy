package com.udemy.junitmockito.resources;

import com.udemy.junitmockito.dto.UserDTO;
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
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        User newUser = userService.createUser(user);
        return ResponseEntity.ok().body(new UserDTO(
                newUser.getId(),
                newUser.getName(),
                newUser.getEmail(),
                newUser.getPassword()));
    }
}
