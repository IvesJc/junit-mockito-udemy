package com.udemy.junitmockito.repositories;

import com.udemy.junitmockito.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
