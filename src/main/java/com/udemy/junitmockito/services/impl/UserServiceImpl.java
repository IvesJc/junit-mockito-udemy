package com.udemy.junitmockito.services.impl;

import com.udemy.junitmockito.dto.UserDTO;
import com.udemy.junitmockito.models.User;
import com.udemy.junitmockito.repositories.UserRepository;
import com.udemy.junitmockito.services.UserService;
import com.udemy.junitmockito.services.exceptions.EmailAlreadyExistsException;
import com.udemy.junitmockito.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser.orElseThrow(ObjectNotFoundException::new);
    }

    @Override
    public User createUser(UserDTO userDTO) {
        User newUser = new User(
                userDTO.id(),
                userDTO.name(),
                userDTO.email(),
                userDTO.password());

        findByEmail(userDTO);
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public void deleteUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            userRepository.deleteById(id);
        }
        throw new ObjectNotFoundException();
    }

    private void findByEmail(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findByEmail(userDTO.email());

        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistsException();
        }
    }
}
