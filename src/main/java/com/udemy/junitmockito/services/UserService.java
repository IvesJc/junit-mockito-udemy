package com.udemy.junitmockito.services;

import com.udemy.junitmockito.dto.UserDTO;
import com.udemy.junitmockito.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Integer id);
    User createUser(UserDTO userDTO);

    User updateUser(Integer id, UserDTO userDTO);
    void deleteUser(Integer id);

}
