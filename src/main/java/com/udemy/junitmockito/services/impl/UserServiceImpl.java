package com.udemy.junitmockito.services.impl;

import com.udemy.junitmockito.dto.UserDTO;
import com.udemy.junitmockito.models.User;
import com.udemy.junitmockito.repositories.UserRepository;
import com.udemy.junitmockito.services.UserService;
import com.udemy.junitmockito.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser.orElseThrow(ObjectNotFoundException::new);
    }

    public User createUser(UserDTO userDTO){
        User newUser = new User(
                userDTO.id(),
                userDTO.name(),
                userDTO.email(),
                userDTO.password());
        userRepository.save(newUser);
        return newUser;
    }
}
