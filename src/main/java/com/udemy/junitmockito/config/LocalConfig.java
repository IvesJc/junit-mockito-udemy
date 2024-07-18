//package com.udemy.junitmockito.config;
//
//import com.udemy.junitmockito.models.User;
//import com.udemy.junitmockito.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import java.util.List;
//
//@Configuration
//@Profile("local")
//public class LocalConfig {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public void startDB(){
//        User u1 = new User(null, "Fulano", "fulano@email.com", "123");
//        User u2 = new User(null, "Ciclano", "ciclano@email.com", "123");
//
//        userRepository.saveAll(List.of(u1, u2));
//    }
//}
