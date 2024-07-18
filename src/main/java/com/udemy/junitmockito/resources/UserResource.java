package com.udemy.junitmockito.resources;

import com.udemy.junitmockito.dto.UserDTO;
import com.udemy.junitmockito.models.User;
import com.udemy.junitmockito.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    public static final String ID = "/{id}";

    @Autowired
    UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll().
                stream().
                map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword())).toList());
    }

    @GetMapping(ID)
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        User newUser = userService.findById(id);
        return ResponseEntity.ok(mapper(newUser));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        URI uri =
                ServletUriComponentsBuilder.
                        fromCurrentRequest().
                        path(ID).
                        buildAndExpand(
                                userService.createUser(user).getId()
                        ).
                        toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(ID)
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id,
                                              @RequestBody UserDTO userDTO){
        User newUser = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(mapper(newUser));
    }

    @DeleteMapping(ID)
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

    }
    public UserDTO mapper(User newUser){
        return new UserDTO(newUser.getId(), newUser.getName(), newUser.getEmail(),
                newUser.getPassword());
    }
}
