package com.udemy.junitmockito.services;

import com.udemy.junitmockito.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Integer id);
    User createUser(User user);
}
